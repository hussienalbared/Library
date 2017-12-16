<%-- 
    Document   : userProfile
    Created on : Dec 21, 2016, 6:24:28 PM
    Author     : AG
--%>

<%@page import="com.Models.userModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    userModel user = (userModel)session.getAttribute("activeuser");
    String user_Name = user.getName();
    String user_Email = user.getEmail();
    String user_password= user.getPassword();
    int type= user.getType();
    String home;
    if(type==1){
        home="newjsp.jsp";
    }
    else {
        home="studenthome.jsp";}
%>
<html>
    <head>
        <title>
        </title>
        <link rel="stylesheet" href="userProfileStyle.css">
        
    </head>
    <body>
        <div id="header">
            <ul>
                <li><a href="<%=home %>" id="logo"><img src="images/bookSite.jpg" width="130" height="70"></a></li>
                <li id="item"><a href="<%=home %>">home</a></li>
                <li id="item"><a href="#">english books</a></li>
                <li id="item"><a href="#">arabic books</a></li>
                <li id="item"><a href="#">about us</a></li>
            </ul>
            <h1 id="account">Account</h1>
        </div>
        <div id="accoConrainer">
            <div id="accoleft">
                <img src="images/accountPhoto.png" width="90" height="90">
                <h3 id="accouserName">Ame Almajeedi</h3>
                <div id="accoProfileList">
                    <div id="accod1">
                        <ul>
                            <li><img src="images/userIcon.png" width="20" height="20" id="usericon"></li>
                            <li><a href="#" id="itemhr">Account</a></li>
                        </ul>
                    </div>
                    <div id="accod1">
                        <ul>
                            <li><img src="images/settingIcon.png" width="20" height="20" id="usericon"></li>
                            <li><a href="Inbox" id="itemhr">Inbox</a></li>
                        </ul>
                    </div>
                    <div id="accod1">
                        <ul>
                            <li><img src="images/Hopstarter-Book-Sketchpad-Book.ico" width="20" height="20" id="usericon"></li>
                            <li><a href="UserbowroedBooks" id="itemhr">Borrowed Books</a></li>
                        </ul>
                    </div>
                    <div id="accod1">
                        <ul>
                            <li><img src="images/deleteIcon.png" width="20" height="20" id="usericon"></li>
                            <li><a href="#" id="itemhr">Delete Account</a></li>
                        </ul>
                    </div>
                    
                </div>
            </div>
            <div id="accoright">
                <ul>
                    <li><img src="images/userIcon.png" width="20" height="20" id="usericon"></li>
                    <li><a href="#" id="itemhr">Account</a></li>
                </ul>
                <form action="updateAccount">
                    <label class="acoLabel">Username</label>
                    <input type="text" placeholder=<%=user_Name%> class="cooName" name="Name">
                    
                    <label class="acoLabel">E-mail Address</label>
                    <input type="text" placeholder=<%=user_Email %> class="cooName" name="email"><br>
                    
                    <label class="acoLabel">Password</label>
                    <input type="text" placeholder=<%=user_password %> class="cooName" name="pass"><br>
                    
                    <label class="acoLabel">Type</label>
                    <input type="text" placeholder=<%=type %> class="cooName" name="type"><br>
                    
                    <input type="submit" value="Update Account" id="cooUpdatebutton">
                </form>
            </div>
        </div>
        
        <div id="accoFooter">
        </div>
        
    </body>
</html>