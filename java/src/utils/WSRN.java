package src.utils;

/**
 * Created by rafaganabreu on 16/02/15.
 */
//Web Service Response Namespaces
    // O objetivo desta classe é modificar o nome do topo da hierarquia JSON
public class WSRN {
    public static abstract class AbstractResponse {
        private String status = "OK";

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class Response extends AbstractResponse {
        private Object result;

        public Response() { }
        public Response(Object result) {
            this.result = result;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }
    }

    public static class ResponseBone extends AbstractResponse {
        private Object bones;

        public ResponseBone() { }
        public ResponseBone(Object result) {
            this.bones = result;
        }

        public Object getBones() {
            return bones;
        }

        public void setBones(Object bones) {
            this.bones = bones;
        }
    }

    public static class ResponseBoneSet extends AbstractResponse {
        private Object boneSets;

        public ResponseBoneSet() { }
        public ResponseBoneSet(Object result) {
            this.boneSets = result;
        }

        public Object getBoneSets() {
            return boneSets;
        }

        public void setBoneSets(Object result) {
            this.boneSets = result;
        }
    }

    public static class ResponseQuizTestDto extends AbstractResponse {
        private Object quizTestsDto;

        public ResponseQuizTestDto() { }
        public ResponseQuizTestDto(Object result) {
            this.quizTestsDto = result;
        }

        public Object getQuizTestsDto() {
            return quizTestsDto;
        }

        public void setQuizTestsDto(Object result) {
            this.quizTestsDto = result;
        }
    }

    public static class ResponseQuizTest extends AbstractResponse {
        private Object quizTests;

        public ResponseQuizTest() { }
        public ResponseQuizTest(Object result) {
            this.quizTests = result;
        }

        public Object getQuizTests() {
            return quizTests;
        }

        public void setQuizTests(Object result) {
            this.quizTests = result;
        }
    }

    public static class ResponseQuestion extends AbstractResponse {
        private Object questions;

        public ResponseQuestion() { }
        public ResponseQuestion(Object result) {
            this.questions = result;
        }

        public Object getQuestions() {
            return questions;
        }

        public void setQuestions(Object result) {
            this.questions = result;
        }
    }
}
