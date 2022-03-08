<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Name:Huanghao</h1>
<h1>ID:2020211001001224</h1>
<h1>Date and Time:sun March 6 22:38:44 CST 2021</h1><br>

<div style="text-align: center;">
    <form name="form">
        <input type="text" placeholder="Username" name="Username"><br>
        <input type="password" placeholder="password" name="password"><br>
        <input type="email" placeholder="Email" name="Email"><br>
        <input type="radio" name="sex" value="man" />男
        <input type="radio" name="sex" value="woman" />女<br>
        <input type="text" placeholder="Date of Birth(yyy-mm-dd)" name="Date"><br>
        <input type="submit" name="submit" id="sb">
    </form>
</div>

<script>
    document.getElementById("sb").onclick=function click(){
        var a=form.Username.value.trim();
        var b=form.password.value.trim().length;
        var c=form.Email.value.trim().length;
        var d=form.Date.value.trim();
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