package com.huanghao.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "ConfigDemoServlet",urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name",value = "huanghao"),
                @WebInitParam(name = "studentID",value = "2020211001001224"),
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String studentID=config.getInitParameter("studentID");
        PrintWriter writer=response.getWriter();
        writer.println("<br> name:"+name);
        writer.println("<br> studentID:"+studentID);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
