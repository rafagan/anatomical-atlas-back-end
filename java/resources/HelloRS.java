package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rafaganabreu on 20/09/14.
 */

@Path("hello_rs")
public class HelloRS {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

    @GET
	@Produces(CONTENT_TYPE_APPLICATION_JSON)
	public Response responseOk() {
		return Response.ok("Hello Jersey!").build();
	}
}
