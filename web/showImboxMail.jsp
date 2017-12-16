<%-- 
    Document   : showImboxMail
    Created on : Dec 24, 2016, 1:38:20 PM
    Author     : AG
--%>

<%@page import="com.Models.userModel"%>
<%@page import="com.Models.emailModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="userProfileStyle.css">
        <style>
            body{text-align: center}
            label{font-size: 15px;font-weight: bold;}
            #header{margin-bottom: 20px}
        </style>
    </head>
    
    <body>
        <%
    String Title,Auther,updater,imageLink;
    int Year,ISBN=0;
    
    userModel user = (userModel)session.getAttribute("activeuser");
    int type = user.getType();
    String home;
    if(type==1){
        home="newjsp.jsp";
    }
    else {
        home="studenthome.jsp";}
    updater = "amr@h";
%>
        
        <div id="header">
            <ul>
                <li><a href="<%=home %>" id="logo"><img src="images/bookSite.jpg" width="130" height="70"></a></li>
                <li id="item"><a href="<%=home %>">home</a></li>
                <li id="item"><a href="#">english books</a></li>
                <li id="item"><a href="#">arabic books</a></li>
                <li id="item"><a href="#">about us</a></li>
            </ul>
            <h1 id="account">My Inbox</h1>
        </div>
                
                <%
            ArrayList<emailModel> inboxEmails = (ArrayList<emailModel>) session.getAttribute("MyInbox");
            if(inboxEmails==null || inboxEmails.size()==0){
                %><h2>No Emails ...</h2>
                <%
            }
            else {
                for(int i=0 ;i<inboxEmails.size();i++){%>
                <label>From: </label><%=inboxEmails.get(i).getSenderEmail()%><br>
                <label>To: </label><%=user.getEmail() %><br>
                <label>Subject: </label><%=inboxEmails.get(i).getSubject()%><br>
                <label>Body: </label><%=inboxEmails.get(i).getBody()%><br>
                <label>Time: </label><%=inboxEmails.get(i).getTime()%><br>
                                            <div id="EBFooter">
                                <img src="images/br5.jpg" width="450px" height="100px">
                            </div>

           <% }}

        %>
    </body>
</html>
