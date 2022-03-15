package com.example.huanghao2020211001001224;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    Statement stmt=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //插
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String date=request.getParameter("date");

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

        //查
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="select username,password,email,sex,birth from usertable ";
        try {
            ResultSet rs= stmt.executeQuery(sql);
            if(rs.next()){
                PrintWriter writer=response.getWriter();
                writer.println("<html>");
                writer.println("<head><title>table</title></head>");
                writer.println("<body><table>");
                writer.println("<tr>");
                writer.println("<td>username</td>");
                writer.println("<td>password</td>");
                writer.println("<td>email</td>");
                writer.println("<td>sex</td>");
                writer.println("<td>birth</td>");
                writer.println("</tr>");
                writer.println("<tr>");
                writer.println("<td>"+username+"</td>");
                writer.println("<td>"+password+"</td>");
                writer.println("<td>"+email+"</td>");
                writer.println("<td>"+sex+"</td>");
                writer.println("<td>"+date+"</td>");
                writer.println("</tr>");
                writer.println("</table>");
                writer.println("</body>");
                writer.println("</html>");
            }
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
