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
import java.util.UUID;

public class MessagesIO extends HttpServlet {

    static MessagesIO messagesIO;
    private Messages messages;
    public Users users;

    @Override
    public void init() throws ServletException {
        users = new Users(recovery());
        messages = new Messages();
        messagesIO = this;
    }

    private HashMap<String, User> recovery(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.dat")))
        {
            return (HashMap<String, User>) ois.readObject();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return new HashMap<String, User>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println( messages.toString() );
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mes = req.getParameter("key");
        User user = Users.us.getUser( mes);

        if(user == null){
           user.setStatus();
        }else {
            messages.addMessage(mes);
            resp.setContentType("string");
            PrintWriter messageWriter = resp.getWriter();
            messageWriter.println(messages.toString());

        }

    }

}
