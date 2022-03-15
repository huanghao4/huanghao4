<%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/5/18
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <tr>
        <td>Name:</td>
        <td><%=request.getParameter("username")%></td>
    </tr>
    <tr>
        <td>Class:</td>
        <td><%=request.getParameter("Class")%></td>
    </tr>
    <tr>
        <td>id:</td>
        <td><%=request.getParameter("id")%></td>
    </tr>
    <tr>
        <td>submit:</td>
        <td><%=request.getParameter("submit")%></td>
    </tr>

</table>

Name:${param.name}<br>
Class:${param.Class}<br>
id:${param.id}<br>
submit:${param.submit}<br>
</body>
</html>
