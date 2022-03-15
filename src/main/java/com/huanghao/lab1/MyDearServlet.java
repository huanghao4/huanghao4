package com.huanghao.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/myDear")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String Class=request.getParameter("Class");
        String id=request.getParameter("id");
        String submit=request.getParameter("submit");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title></title><body>");
        out.println("<br> name:"+username);
        out.println("<br> Class:"+Class);
        out.println("<br> id:"+id);
        out.println("<br> submit"+submit);
        out.println("</body>");
        out.println("</html>");

    }
}
