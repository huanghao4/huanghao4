package com.huanghao.controller;

import com.huanghao.dao.UserDao;
import com.huanghao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    Connection con=null;
    Statement stmt=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO 1:foreword to WEB-INF/views/updateUser.jsp
        //TODO 2:create one page --updateUser
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO 1 get all request parameters
        //TODO 2 create an object of User Model
        //TODO 3 set all request parameters into User Model
        //TODO 4 create an object of UserDao
        //TODO 5 call updateUser() in UserDao

        //TODO 6 foreword to WEB-INF/views/userInfo.jsp

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
       // int id=user.getId();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birth=request.getParameter("birth");

        UserDao userDao=new UserDao();
        if (username!=""){
            user.setUsername(username);
        }
        if (password!=""){
            user.setPassword(password);
        }
        if (email!=""){
            user.setEmail(email);
        }
        if (sex!=null){
            user.setSex(sex);
        }
        if (birth!=""){
            user.setBirth(birth);
        }

        try {
            userDao.updateUser(con,user);
            request.getRequestDispatcher("accountDetails").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
