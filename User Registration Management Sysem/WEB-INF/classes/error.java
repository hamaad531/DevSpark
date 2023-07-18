import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class error extends HttpServlet {
    public static void getError(HttpServletRequest request, HttpServletResponse response, String msg) {

        try {
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error occured</h1>");
            out.println("<h2>" + msg + "</h2>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}