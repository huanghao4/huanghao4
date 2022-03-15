package com.huanghao.lab1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("I Am from default constructor");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int count=0;
        if (request.getSession().getAttribute("count")!=null){
            count=(Integer) request.getSession().getAttribute("count");
        }
        count++;
        request.getSession().setAttribute("count",count);
        PrintWriter out=response.getWriter();
        out.println("This is the "+count+" times");
        out.println("huanghao");
    }
}
