package controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servlet2", urlPatterns = { "/hello_servlet2" })
public class HelloServletHtml extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServletHtml() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Primeira Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Oi mundo Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }
}
