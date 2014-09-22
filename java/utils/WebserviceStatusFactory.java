package utils;

/**
 * Created by admin on 07/08/14.
 */
public class WebserviceStatusFactory {

    private WebserviceStatusFactory() {}

    public static WebserviceStatus nullValue(String attributeName) {
        return new WebserviceStatus(1, "O atributo '" + attributeName + "' não foi passado ou ele tem uma referência nula.");
    }

    public static WebserviceStatus negativeValue(String attributeName) {
        return new WebserviceStatus(2, "O atributo '" + attributeName + "' não pode ser negativo.");
    }

    public static WebserviceStatus outOfBoundsValue(String attributeName, long lowerValue, long higherValue) {
        return new WebserviceStatus(3, "O atributo '" + attributeName + "' está fora do escopo " + lowerValue + " até " + higherValue + ".");
    }

    public static WebserviceStatus outOfBoundsValue(String attributeName, double lowerValue, double higherValue) {
        return new WebserviceStatus(3, "O atributo '" + attributeName + "' está fora do escopo " + lowerValue + " até " + higherValue + ".");
    }

    public static WebserviceStatus emptyString(String attributeName) {
        return new WebserviceStatus(4, "O atributo '" + attributeName + "' é uma string vazia.");
    }

    public static WebserviceStatus invalidCredential() {
        return new WebserviceStatus(5, "E-mail e/ou senha inválidos.");
    }

    public static WebserviceStatus duplicateEmail() {
        return new WebserviceStatus(6, "E-mail já foi utilizado no cadastro de outra conta.");
    }

    public static WebserviceStatus unauthorizedUser() {
        return new WebserviceStatus(401, "Acesso negado à este conteúdo.");
    }

    public static WebserviceStatus databaseError(String databaseErrorName) {
        return new WebserviceStatus(500, "Erro interno no banco de dados. Favor contactar o administrador de banco de dados e informar a seguinte mensagem: " + databaseErrorName);
    }

    // TODO: mensagens de banco de dados (chave primária duplicada, etc).

    public static class WebserviceStatus {
        private int code;
        private String message;

        public WebserviceStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
