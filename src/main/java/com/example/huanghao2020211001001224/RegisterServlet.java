package com.example.huanghao2020211001001224;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String date=request.getParameter("date");

        PrintWriter writer=response.getWriter();
        writer.println("<br> username"+username);
        writer.println("<br> password"+password);
        writer.println("<br> email"+email);
        writer.println("<br> sex"+sex);
        writer.println("<br> date"+date);
        writer.close();
    }
}
