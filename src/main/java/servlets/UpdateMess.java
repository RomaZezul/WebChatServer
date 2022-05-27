
package servlets;

        import classes.User;
        import classes.data.Users;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

        import java.io.IOException;
        import java.io.PrintWriter;

public class UpdateMess extends HttpServlet {



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        User user = Users.us.getUser( key);
        if(user != null){
            user.setStatus();
        }

        resp.setContentType("application/json");
        resp.getOutputStream().write(MessagesIO.messagesIO.messages.getMessagesJson());

        System.out.println(MessagesIO.messagesIO.messages.getMessagesJson());

    }

}
