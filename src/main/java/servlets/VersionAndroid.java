package servlets;

import classes.User;
import classes.data.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class VersionAndroid extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write( "https://drive.google.com/file/d/1xrRtGDoyAWplCeOhKRIpMBSUsv5vaNIg/view?usp=sharing" );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String version = req.getParameter("version");

        resp.setContentType("string");
        resp.getWriter().write("1.0");
    }

}
