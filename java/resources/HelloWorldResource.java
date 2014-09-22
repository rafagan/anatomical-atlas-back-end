package resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "hello", urlPatterns = "/jesus")
public class HelloWorldResource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Teste");
    }
}

//@Path("hello")
//public class HelloWorldResource {
//    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";
//	@GET
//	@Produces(CONTENT_TYPE_APPLICATION_JSON)
//	public Response responseOk() {
//		return Response.ok("Hello Anatomical Atlas!").build();
//	}
//}


/*
ChangeStudentProfile
GenerateQuizTest:
Sistema de convite para uma classe
PostLogin - Criptografia
 */