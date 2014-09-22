package utils;

import java.util.ArrayList;

/**
 * Created by admin on 08/08/14.
 */

public class WebserviceResponseFactory {
    private WebserviceResponseFactory() {

    }

    public static WebserviceResponse normalSingleResponse(Object object) {
        return new WebserviceResponse(
                WebserviceResponseStatus.OK.status,
                object
        );
    }

    public static WebserviceResponse normalListResponse() {
        return new WebserviceResponse(
                WebserviceResponseStatus.OK.status,
                new ArrayList<>()
        );
    }

    public static WebserviceResponse errorListResponse() {
        return new WebserviceResponse(
                WebserviceResponseStatus.FAILED.status,
                new ArrayList<WebserviceStatusFactory.WebserviceStatus>());
    }

    public static class WebserviceResponse {
        private String status;
        private Object result;

        public WebserviceResponse(String status, Object p1) {
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
