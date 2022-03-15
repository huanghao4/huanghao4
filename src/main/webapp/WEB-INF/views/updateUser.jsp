<%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/4/18
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update </h1>

<%
    User u=(User) session.getAttribute("user");
%>
<form name="form" method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>" >
    <input type="text" placeholder="username" name="username" value="<%=u.getUsername()%>"><br>
    <input type="password" placeholder="password" name="password" value="<%=u.getPassword()%>"><br>
    <input type="email" placeholder="email" name="email" value="<%=u.getEmail()%>"><br>
    <input type="radio" name="sex" value="male" <%="male".equals(u.getSex())?"check":""%>/>male
    <input type="radio" name="sex" value="female"  <%="female".equals(u.getSex())?"check":""%>/>female<br>
    <input type="text" placeholder="Date of Birth(yy-mm-dd)" name="birth" value="<%=u.getBirth()%>"><br>
    <input type="submit" value="save changes">
</form>
<%@include file="footer.jsp"%>
