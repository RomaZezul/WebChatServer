package servlets;

import classes.data.Users;
import classes.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple class that extends {@link HttpServlet}.
 *
 * @author Eugene Suleimanov
 */
public class Login extends HttpServlet {

    private String message;


//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("string");
//        User u = Data.D.setUser("asdd");
//        PrintWriter messageWriter = response.getWriter();
//        messageWriter.println( u.toString() );
//
// }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key").trim();
        User user = Users.us.getUser( key);

        String s = "";
        if(user != null){
            s = user.getNick();
        }
        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println(s);

    }

}



























