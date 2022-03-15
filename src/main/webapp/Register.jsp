<%--
  Created by IntelliJ IDEA.
  User: huanghao
  Date: 2022/3/14
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="form" method="post" action="jdbc">
        <input type="text" placeholder="username" name="username"><br>
        <input type="password" placeholder="password" name="password"><br>
        <input type="email" placeholder="email" name="email"><br>
        <input type="radio" name="sex" value="male" />male
        <input type="radio" name="sex" value="female" />female<br>
        <input type="text" placeholder="Date of Birth(yy-mm-dd)" name="date"><br>
        <input type="submit" name="submit" id="sb">
    </form>

<script>
    document.getElementById("sb").onclick=function click(){
        var a=form.username.value.trim();
        var b=form.password.value.trim().length;
        var c=form.email.value.trim().length;
        var d=form.date.value.trim();
        if(b<8){
            alert("The password length must be more than eight digits!")
        }else if(c!=10){
            alter("Date format error!")
        }
        if(a!=0 && b>=8 && c!=10 && d!=0){
            alert("Login is successful!")
        }else{
            alert("Incomplete information!")
        }
    }
</script>
</body>
</html>
