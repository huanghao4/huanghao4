package com.huanghao.week6.Demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect-same server -Relative url
        //1.start without
        System.out.println("before direct");

        //response.sendRedirect("index.jsp");//url change to index
        //http://localhost:8080/2020211001001224Huanghao_war_exploded/index.jsp
        //http://localhost:8080/2020211001001224Huanghao_war_exploded/redirect
        //url from redirect to index

        System.out.println("after direct");

        //2.start with
        //response.sendRedirect("/2020211001001224Huanghao_war_exploded/index.jsp");
        //http://localhost:8080/2020211001001224Huanghao_war_exploded/redirect
        //http://localhost:8080/index.jsp
        //add /2020211001001224Huanghao_war_exploded

        //redirect -another server-Absolute url
        response.sendRedirect("https://www.baidu.com/");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
