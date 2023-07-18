import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null) {
            error.getError(request, response, "Please enter all fields");
            return;
        }

        PrintWriter out = response.getWriter();
        Connection con = Dbconnection.getConnection();
        ResultSet res = null;
        try {
            Statement stat = con.createStatement();
            String query = "Select * from sign_log where email = '" + email + "' AND password = '" + password + "'";
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {

                // Cookie c1 = new Cookie("user", email);
                // Cookie c2 = new Cookie("pass", password);
                // c1.setMaxAge(60 * 60 * 12 * 30);
                // c2.setMaxAge(60 * 60 * 12 * 30);
                HttpSession session = request.getSession(true);
                session.setAttribute("user", email);
                session.setAttribute("username", rs.getString("username"));
                session.setAttribute("password", password);
                session.setAttribute("type", rs.getString("usertype"));
                session.setMaxInactiveInterval(12 * 60 * 60);
                // adding cookies
                // response.addCookie(c1);
                // response.addCookie(c2);
                response.sendRedirect("dashboard.jsp");
                // response.sendRedirect("dashboardadmin.jsp");
            } else {
                error.getError(request, response, "Incorrect " + email + " && " + password);
            }
            stat.close();
            con.close();
        } catch (Exception ex) {
            error.getError(request, response, "Server Error Occured");
        }
        out.close();
    }
}