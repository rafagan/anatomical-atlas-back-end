package utils;

import java.util.ArrayList;

/**
 * Created by admin on 08/08/14.
 */

public class WSResponseFactory {
    private WSResponseFactory() {

    }

    public static WSResponse normalSingleResponse(Object object) {
        return new WSResponse(
                WebserviceResponseStatus.OK.status,
                object
        );
    }

    public static WSResponse normalListResponse() {
        return new WSResponse(
                WebserviceResponseStatus.OK.status,
                new ArrayList<>()
        );
    }

    public static WSResponse errorListResponse() {
        return new WSResponse(
                WebserviceResponseStatus.FAILED.status,
                new ArrayList<WebserviceStatusFactory.WebserviceStatus>());
    }

    public static class WSResponse {
        private String status;
        private Object result;

        public WSResponse(String status, Object p1) {
            setStatus(status);
            setResult(p1);
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }
    }

    public enum WebserviceResponseStatus {
        OK("OK"),
        FAILED("FAILED");

        String status;

        WebserviceResponseStatus(String status) {
            this.status = status;
        }
    }
}
