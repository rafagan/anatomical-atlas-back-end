package utils;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rafaganabreu on 26/10/14.
 */
public class UserAuthentication {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public int passwordHash;

    public UserAuthentication(String email, String password) {
        passwordHash = new HashCodeBuilder(107,31).
                append(email).
                append(password).
                append("Anatomical Atlas Web Service").
                toHashCode();
    }

    public boolean authenticateNewAccount() {
        //Validar e-mail como possível e válido
        //Validar demais dados como válidos
        //Gerar hash da senha do usuário
        //Criar registro do professor/aluno
        //Criar registro do login

        return true;
    }

    public boolean authenticateLogin() {
        //Validar se o e-mail existe
        //Validar se a senha esta correta
        //Atualizar informações da tabela de login
        //Retornar sucesso da transação

        return true;
    }
}
