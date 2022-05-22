
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
        String mes = req.getParameter("key");
        User user = Users.us.getUser( mes);
        if(user != null){
            user.setStatus();
        }

        resp.setContentType("string");
        PrintWriter messageWriter = resp.getWriter();
        messageWriter.println(MessagesIO.messagesIO.messages.toString());


    }

}
