<%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/3/30
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.huanghao.week4.JDBCDemoServlet" %>
<h1>User List</h1>
<table border="1">
    <tr>
    <td>Id</td><td>username</td><td>password</td><td>email</td><td>sex</td><td>birth</td>
    </tr>
    <%
        ResultSet rs= (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td> no date</td>
    </tr>
            <%}else {
                while (rs.next()) {
                    out.println("<tr>");
//                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("username") + "</td>");
                    out.println("<td>" + rs.getString("password") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("sex") + "</td>");
                    out.println("<td>" + rs.getString("birth") + "</td>");
                    out.println("</tr>");
                }
            }

    %>


</table>
<%@include file="footer.jsp"%>>
