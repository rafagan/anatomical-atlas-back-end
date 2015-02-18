package src.resources;

import src.utils.DummyInsertion;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by rafaganabreu on 20/09/14.
 */
@Path("v1/hello_rs")
public class HelloRS extends AbstractResource {
    @GET
	@Produces(CONTENT_TYPE_APPLICATION_JSON)
	public Response responseOk() {
		return Response.ok("Hello Jersey Testando!").build();
	}

    @POST
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response loadDummyData() {
        new DummyInsertion().run();
        return Response.ok("Conteúdo adicionado com sucesso ao banco").build();
    }

    @PUT
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response responseOkPut(@PathParam("id") int value, @QueryParam("q") int qValue) {
        return Response.ok(value + qValue).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response responseOkDelete(@PathParam("id") int value, @QueryParam("q") int qValue) {
        return Response.ok(value - qValue).build();
    }
}
