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
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//name=value
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=register;encrypt=false";
        String username = "huanghao";
        String password = "123456";
        try {
            Class.forName(driver);
            System.out.println("成功");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");
            System.out.println("连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                PrintWriter writer = response.getWriter();
                writer.println("Login Success!!!");
                writer.println("Welcome"+username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
