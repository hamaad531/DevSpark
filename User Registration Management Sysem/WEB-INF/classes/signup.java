import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class signup extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        out.println("hello i am here baby!");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String usertype = request.getParameter("usertype");
        System.out.println("debugging 1");
        String type;
        if (usertype.equals("admin")) {
            type = "0";
        } else {
            type = "1";
        }
        String err = null;
        if (username == null || email == null || password == null) {
            error.getError(request, response, "please enter all fields");
            return;
        } else {
            if (!password.equals(cpassword)) {
                error.getError(request, response, "password and confirm password must be same");

                return;
            } else if (username.length() < 3 || username.length() > 10) {
                err = "first name must be between 3 - 10 chars";
            } else if (password.length() < 6 || password.length() > 15) {
                err = "password must be between 6 - 15 chars";
            } else if (email.length() < 5 || email.length() > 20) {
                err = "enter valid email";
            }
            System.out.println("debugging 2");
            if (err != null) {
                error.getError(request, response, err);

                return;
            }
            System.out.println("debugging 1");
            Connection con = Dbconnection.getConnection();
            Statement stat = null;
            try {

                stat = con.createStatement();
                String query = "Select * from sign_log where email = '" + email + "'";
                ResultSet rs = stat.executeQuery(query);

                if (rs.next()) {
                    error.getError(request, response, email + "already exist");
                } else {
                    System.out.println("debugging 2");
                    String y1 = "INSERT INTO sign_log (username, email, password, usertype) VALUES('" + username
                            + "', '" + email + "', '" + password + "', '" + usertype + "');";
                    int result = stat.executeUpdate(y1);

                    //  error.getEr ror(request error: package; javax.servlet.http does not existt,
                    // // response, "Success fully registered");
                    error.getError(request, response, "Success fully registered");

                }
            } catch (NullPointerException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println("SQLException" + e);
            }

        }

    }

}