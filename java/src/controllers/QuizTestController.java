package src.controllers;

import src.dao.QuestionDao;
import src.dao.QuizTestDao;
import src.dtos.PublicQuizTestDtoPost;
import src.dtos.QuizTestDtoGetAll;
import src.models.BoneSet;
import src.models.Question;
import src.models.QuizTest;
import src.models.Teacher;
import src.utils.EntityManagerUtil;
import src.utils.WSRN;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class QuizTestController extends AbstractController {
    QuizTestDao qtDao;

    public QuizTestController() {
        dao = qtDao = new QuizTestDao();
    }

    public Response getAllPublicQuizTests() { //Preciso que o quiz test volte com suas respectivas categorias
        WSRN.ResponseQuizTestDtoGetAll wResponse = new WSRN.ResponseQuizTestDtoGetAll();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = qtDao.queryPublicQuizTests();
        List<QuizTestDtoGetAll> result = new ArrayList<>();

        for(QuizTest qt : quizTests) {
            QuizTestDtoGetAll qtdto = new QuizTestDtoGetAll();
            qtdto.setMaxQuestions(qt.getMaxQuestions());
            qtdto.setDifficultLevel(qt.getDifficultLevel());
            qtdto.setTitle(qt.getTitle());
            qtdto.setIdQuizTest(qt.getIdQuizTest());

            qt.setResolutions(null);
            qt.setAuthor(null); //Se é pública, o autor será nulo de qualquer maneira

            List<Integer> categories = new ArrayList<>();
            for(Question q : qt.getQuestions()) {
                for (BoneSet bs : q.getCategories()) {
                    categories.add(bs.getIdBoneSet());
                }
            }

            qtdto.setCategories(categories);
            qt.setQuestions(null);
            result.add(qtdto);
        }

        wResponse.setQuizTestsDto(quizTests);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuizTest(int quizTestId, boolean full) {
        WSRN.ResponseQuizTest wResponse = new WSRN.ResponseQuizTest();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        QuizTest quizTest = qtDao.queryPublicQuizTest(quizTestId);

        quizTest.setResolutions(null);
        quizTest.setAuthor(null); //Se é pública, o autor será nulo de qualquer maneira

        if(!full)
            quizTest.setQuestions(null);
        else
            for(Question q : quizTest.getQuestions()){
                q.setQuizTests(null);

                for(BoneSet cat : q.getCategories()) {
                    cat.setBoneChildren(null);
                    cat.setParent(null);
                    cat.setRelatedQuestions(null);
                    cat.setBoneSetChildren(null);
                }

                for(Teacher author : q.getAuthors()) {
                    author.setWorkingOrganizations(null);
                    author.setOwnerOfOrganizations(null);
                    author.setOwnerOfClasses(null);
                    author.setMonitoratedClasses(null);
                    author.setMyQuizTests(null);
                    author.setMyQuestions(null);
                    author.setLogin(null);
                }
            }

        wResponse.setQuizTests(quizTest);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public void insertPublicQuizTest(PublicQuizTestDtoPost dto) {
        qtDao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        QuizTest qt = new QuizTest();
        qt.setAuthor(null);
        qt.setTitle(dto.getTitle());
        qt.setDifficultLevel(dto.getDifficult());
        qt.setMaxQuestions(dto.getMaxQuestions());
        qt.setResolutions(null);

        if(!dto.isAutomatic())
            for (Integer id : dto.getQuestions()) {
                Question q = (Question) qtDao.get().findObject(Question.class,id);
                qt.addQuestion(q);
            }
        else {
            int total = new QuestionDao().queryPublicQuestions().size();

            // TODO: Este algoritmo ainda precisará ser aprimorado para levar em consideração
            // temas específicos na montagem aleatória do quiz
            // TODO: Ainda tem que considerar quiz test com autores definidos

            while (qt.getQuestions().size() < dto.getMaxQuestions()) {
                Question q;
                do {
                    q = (Question) qtDao.get().findObject(Question.class, new Random().nextInt() % total);
                } while(qt.getQuestions().contains(q));
                qt.addQuestion(q);
            }
        }

        qtDao.get().insertObject(qt);
        qtDao.get().closeConnection();

        //TODO: É necessário validar os parâmetros recebidos de várias maneiras, pois o javascript não é confiável
    }
}
