package controllers;

import dao.AbstractDao;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ws.rs.core.Response;

/**
 * Created by rafaganabreu on 01/10/14.
 */
public class AbstractController {
    protected AbstractDao dao;

    public Response add(Object newObj)
    {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalSingleResponse(newObj);

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        dao.get().insertObject(newObj);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response remove(Class clss,int id)
    {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        wResponse = WebserviceResponseFactory.normalSingleResponse(dao.get().findObject(clss,id));
        dao.get().removeObject(clss,id);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
