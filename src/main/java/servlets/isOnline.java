package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.HashMap;

public class isOnline extends HttpServlet {

    HashMap<String, Boolean> map;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(resp.getOutputStream()))
        {
            oos.writeObject(MessagesIO.messagesIO.users.getOnlineInfo());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }


    }

}
