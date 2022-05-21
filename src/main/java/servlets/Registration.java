package servlets;
import classes.data.Users;
import classes.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick");
        User user = Users.us.setUser(nick);

        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println(user.getKey());

    }

}
