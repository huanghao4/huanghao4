package com.huanghao.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "JDBCDemoServlet",urlPatterns = {"/jdbc"},
//        initParams = {
//        @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=register;encrypt=false"),
//                @WebInitParam(name = "username",value = "huanghao"),
//                @WebInitParam(name = "password",value = "123456"),
//        },
//        loadOnStartup = 1
//)
@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    Statement stmt= null;
    @Override
    public void init() throws ServletException {
        super.init();
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//name=value
//        String url="jdbc:sqlserver://localhost:1433;DatabaseName=register;encrypt=false";
//        String username="huanghao";
//        String password="123456";
        //1、get servlet config
        //ServletConfig config=getServletConfig();
        //2、get param
        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String username=config.getInitParameter("username");
        //String password=config.getInitParameter("password");

//        ServletContext context=getServletContext();
//        String driver=context.getInitParameter("driver");
//        String url=context.getInitParameter("url");
//        String username=context.getInitParameter("username");
//        String password=context.getInitParameter("password");
//        System.out.println("成功");

//        try {
//            Class.forName(driver);
//            System.out.println("成功");
//            con= DriverManager.getConnection(url,username,password);
//            System.out.println("连接成功");
//            System.out.println("Connection --> in JDBCDemoServlet"+con);
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String date=request.getParameter("date");
        System.out.println("insert into usertable(username,password,email,sex,birth)values('"+username+"','"+password+"','"+email+"','"+sex+"','"+date+"')");
        try {
            stmt= con.createStatement();
            String sql="insert into usertable(username,password,email,sex,birth)values('"+username+"','"+password+"','"+email+"','"+sex+"','"+date+"')";
            int count= stmt.executeUpdate(sql);
            System.out.println("成功");
            if (count==1)
                System.out.println("增加成功");
            else
                System.out.println("增加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            stmt = con.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String sql="select * from usertable ";
        try {
            stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
//            PrintWriter writer=response.getWriter();
//            writer.println("<html><title></title><body><table broder=1><tr>");
//            writer.println("<td>username</td><td>password</td><td>email</td><td>sex</td><td>birth</td>");
//            while(rs.next()){
//                writer.println("<tr>");
//                writer.println("<td>"+rs.getString("username")+"</td>");
//                writer.println("<td>"+rs.getString("password")+"</td>");
//                writer.println("<td>"+rs.getString("email")+"</td>");
//                writer.println("<td>"+rs.getString("sex")+"</td>");
//                writer.println("<td>"+rs.getString("birth")+"</td>");
//                writer.println("</tr>");}
            request.setAttribute("rsname",rs);
            request.getRequestDispatcher("userlist.jsp").forward(request,response);
            System.out.println("i am in RegisterServlet-->dopost()-->after forword()");
//            writer.println("</table></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
