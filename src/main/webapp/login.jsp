<%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/3/29
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
  if (!(request.getAttribute("message")==null)){
    out.println("<h3>"+request.getAttribute("message")+"</h3>");
  }
%>
<form method="post" action="login">
  username:<input type="text"  name="username"><br>
  password:<input type="password"  name="password"><br>
  <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>
