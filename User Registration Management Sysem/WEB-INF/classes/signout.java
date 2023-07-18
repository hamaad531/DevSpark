import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class signout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.setStatus(401);
            out.print("session expired");
        }
        session.invalidate();
        response.setStatus(200);
        out.println("logged out successfully");
        response.sendRedirect("index.html");
    }
}
