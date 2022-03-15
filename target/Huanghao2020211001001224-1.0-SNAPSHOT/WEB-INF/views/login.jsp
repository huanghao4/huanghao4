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
<%
   Cookie[] allCookie= request.getCookies();
   String username="",password="",rememberMeVal="";
   if (allCookie!=null){
     for (int i=0;i<allCookie.length;i++){
       if (allCookie[i].getName().equals("cUsername")){
         username=allCookie[i].getValue();
       }
       if (allCookie[i].getName().equals("cPassword")){
         password=allCookie[i].getValue();
       }
       if (allCookie[i].getName().equals("cRememberMe")){
         rememberMeVal=allCookie[i].getValue();
       }
     }
   }
%>
<form method="post" action="login">
  username:<input type="text"  name="username" value="<%=username%>"><br>
  password:<input type="password"  name="password" value="<%=password%>"><br>
  <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>>Remember me<br/>
  <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>
