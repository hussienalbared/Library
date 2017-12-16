<%-- 
    Document   : Welcome
    Created on : Dec 22, 2016, 4:26:34 PM
    Author     : hussienalbared
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{padding: 350px;padding-top: 70px;background: url(images/backVover.jpeg) no-repeat center center;background-size: cover}
            
            #LogInContainer{border: 1px solid #000;width: 312px;height: 200px;padding: 40px;position: relative;top: 150px;left: 180px;background-color: #fff;padding-bottom: 30px}
            .LognamePass{display: block;width: 300px;margin-bottom: 20px;height: 25px;background-color: none;padding: 5px;border: none}
            #Logbutton{width: 314px;height: 40px;padding: 10px;margin-bottom: 15px;background-color: #F5DEB3;border: none}
            #notRegise{display: inline;margin-left: 50px;color: #808080}
            #creatAccount{text-decoration: none;color: black}
        </style>
    </head>
    
    <body>
       
        <div id="LogInContainer">
            <form action="login">
                <input type="text" name="email" placeholder="email" class="LognamePass">
                <input type="password" name="password" placeholder="password" class="LognamePass">
                <input type="submit" value="LOGIN" id="Logbutton">
            </form>
            <span id="notRegise">Not registered?</span>
            <a href="BookSite_signup.html" id="creatAccount" target="_blank">Create an account</a>
        </div>
        
      
    </body>
</html>
