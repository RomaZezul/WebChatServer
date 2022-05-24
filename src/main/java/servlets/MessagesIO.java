package servlets;

import classes.User;
import classes.data.Messages;
import classes.data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class MessagesIO extends HttpServlet {

    static MessagesIO messagesIO;
    public Messages messages;
    public Users users;

    @Override
    public void init() throws ServletException {
        users = new Users(recovery());
        messages = new Messages();
        messagesIO = this;
    }

    private HashMap<String, User> recovery() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.dat"))) {
            return (HashMap<String, User>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new HashMap<String, User>();
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String nick = req.getParameter("nick");

        messages.addMessage(nick, message);

        resp.setContentType("application/json");
        resp.getWriter().write(MessagesIO.messagesIO.messages.getMessagesJson());


    }

}
