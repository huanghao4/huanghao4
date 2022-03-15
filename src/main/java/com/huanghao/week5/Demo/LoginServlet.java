package com.huanghao.week5.Demo;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    Statement stmt = null;

    @Override
    public void init() throws ServletException {
        super.init();
//        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//name=value
//        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=register;encrypt=false";
//        String username = "huanghao";
//        String password = "123456";
//        try {
//            Class.forName(driver);
//            System.out.println("成功");
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("连接成功");
//            System.out.println("连接成功");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = stmt.executeQuery("select * from usertable where username='" + username + "' and password='" + password + "'");
            if (rs.next()) {
                //week 5 code
                //PrintWriter writer = response.getWriter();
                //writer.println("Login Success!!!");
                //writer.println("Welcome"+username);
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("sex",rs.getString("sex"));
                request.setAttribute("birth",rs.getString("birth"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or password Error!");
                request.getRequestDispatcher("login.jsp").forward(request,response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
