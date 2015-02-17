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
}
