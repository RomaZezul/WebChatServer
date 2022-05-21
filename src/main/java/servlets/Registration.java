package servlets;
import classes.data.Users;
import classes.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("key");
        User user = Users.us.setUser(nick);

        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println(user.getKey());

    }

}
