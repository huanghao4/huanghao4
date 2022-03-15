<%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/5/2
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo-2-week 10</title>
</head>
<body>
<h2>use java code to access String bean class</h2>
  <jsp:useBean id="bean" class="com.huanghao.week10.StringBean"/>
  <jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>

<%
    //com.huanghao.week10.StringBean bean=new StringBean();
    //bean.setMessage("Hello Mr bean - from java code");
%>

Message(java) : <%=bean.getMessage()%>


<h2>use useBean to access StringBean class in jsp</h2>
Message(using getProperty):<jsp:getProperty name="bean" property="message"/>
</body>
</html>
