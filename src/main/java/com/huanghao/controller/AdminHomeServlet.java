package com.huanghao.controller;

import com.huanghao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = {"/admin/home","/admin/login"})
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session!=null && session.getAttribute("user")!=null){
            User user=(User) session.getAttribute("user");
            if (user.getUsername().trim().equals("admin")){
                System.out.println("1");
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            }else {
                System.out.println("2");
                session.invalidate();
                request.setAttribute("message","Unauthorized Access admin module!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            }
        }else {
            System.out.println("3");
            request.setAttribute("message","Please login as admin!");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
