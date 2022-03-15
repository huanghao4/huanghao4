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
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birth=request.getParameter("birth");


        try {
            stmt= con.createStatement();
            String sql="insert into usertable(username,password,email,sex,birth)values('"+username+"','"+password+"','"+email+"','"+sex+"','"+birth+"')";
            int count= stmt.executeUpdate(sql);
            if (count==1)
                System.out.println("增加成功");
            else
                System.out.println("增加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //String sql="select * from usertable ";
        try {
            stmt = con.createStatement();
            //ResultSet rs= stmt.executeQuery(sql);
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
            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userlist.jsp").forward(request,response);
            //System.out.println("i am in RegisterServlet-->dopost()-->after forword()");
//            writer.println("</table></body></html>");
            //week 9
            response.sendRedirect("login");
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
