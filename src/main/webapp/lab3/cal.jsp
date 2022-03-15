<%@ page import="java.io.Serializable" %><%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/6/1
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Cookie[] cookies=request.getCookies();
  String FirstVal="";
  String SecondVal="";
  String Result="";
  String Name="";
  String Length="";
  if (cookies!=null){
    for (Cookie cookie:cookies){
      if (cookie.getName().equals("cFirstVal")){
        FirstVal=cookie.getValue();
      }
      if (cookie.getName().equals("cSecondVal")){
        SecondVal=cookie.getValue();
      }
      if (cookie.getName().equals("cResult")){
        Result=cookie.getValue();
      }
      if (cookie.getName().equals("cName")){
        Name=cookie.getValue();
      }
      if (cookie.getName().equals("cLength")){
        Length=cookie.getValue();
      }
    }

  }

%>
<form method="post" name="form" action="<%=request.getContextPath()%>/cal">
  First Val: <input name="FirstVal" type="text" value="<%=FirstVal%>">
  Enter a Name:<input name="Name" type="text" value="<%=Name%>"><br>
  Second Val:<input name="SecondVal" type="text" value="<%=SecondVal%>">
  Length:<input name="Length" type="text" value="<%=Length%>"><br>
  Result: <input name="Result" type="text" value="<%=Result%>"><br>
  <input id="action1" type="submit" value="Add" name="action">
  <input id="action2" type="submit" value="Subtract" name="action">
  <input id="action3" type="submit" value="Multiply" name="action">
  <input id="action4" type="submit" value="Divide" name="action">
  <input id="action5" type="submit" value="Compute" name="action">
  <input type="reset" value="Reset" name="reset">
</form>
<script>
  document.getElementById("action1").onclick=function click(){
    var a=form.FirstVal.value.trim();
    var b=form.SecondVal.value.trim();

    if (!a.charCode>=48&&a.charCode<=57){
      alert("First value is not a Number")
    }else if (!b.charCode>=48&&b.charCode<=57){
      alert("Second value is not a number")
    }
  }
  document.getElementById("action5").onclick=function click(){
    var c=form.Name.value.trim();
     if (!(c.charCode>=65&&c.charCode<=90)&&!(c.charCode>=97&&c.charCode<=122)){
      alert("Name is not valid")
    }
  }
</script>
</body>
</html>
