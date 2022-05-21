package servlets;

import classes.User;
import classes.data.Messages;
import classes.data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MessagesIO extends HttpServlet {


    private Messages messages;

    @Override
    public void init() throws ServletException {
        new Users();
        messages = new Messages();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println( messages.toString() );
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mes = req.getParameter("message");
        messages.addMessage(mes);

        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println(messages.toString());

    }

}
