<%-- 
    Document   : BowrroedList
    Created on : Dec 23, 2016, 3:00:52 AM
    Author     : AG
--%>

<%@page import="com.Models.userModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Models.bookModels"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String Title,Auther,updater,imageLink;
    int Year,ISBN=0;
    userModel user = (userModel)session.getAttribute("activeuser");
    int t= user.getType();
    String home;
    if(t==1){
        home="newjsp.jsp";
    }
    else {
        home="studenthome.jsp";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css"> 
         <link rel="stylesheet" href="bowrroedBookStyle.css">
        <!--<script src="myJs.js"></script>-->
        <style>
            #ExtendPeriodContainer{text-align: center; border-radius: 4px;background-color: #E3E7E8;display: none;width: 380px;height: 250px;padding: 40px;position: fixed;z-index: 1;left: 0;top: 0; margin-left: 550px;margin-top: 160px;padding: 0px;z-index: 1;left: 0;top: 0;overflow: auto;padding-left: 20px}
        </style>
        <script>
            function ExtendPeriod_II(isbnExtend){
       // alert();
        document.getElementById("ISBNExtend").value=isbnExtend;
        document.getElementById("ExtendPeriodContainer").style.display="block";
        document.getElementById("All").style.opacity=0.3;
    }
        </script>
    </head>
    <body>
        <div id="header">
            <ul>
                <li><a href="<%=home %>" id="logo"><img src="images/bookSite.jpg" width="130" height="70"></a></li>
                <li id="item"><a href="<%=home %>">home</a></li>
                <li id="item"><a href="#">about us</a></li>
            </ul>
            <p id="BooksList"><span id="Mspan">M</span>y Borrowed Books</p>
        </div>
        <div id="BookListContainer">
            <%
        ArrayList<bookModels> AllBooks= null ;
        AllBooks=(ArrayList<bookModels>) session.getAttribute("AllBorrowedBooks");
        if(AllBooks==null || AllBooks.size()==0){
            %><h2 id="EB">No Borrowed Books</h2>
        <%}
        else{
            // Books found%>

            <!--END BackGround Design-->
            
            <%
            for(int i=0;i<AllBooks.size();i++){
                //out.print(AllBooks.get(i).getTitleb()+" ");
                Title = AllBooks.get(i).getTitleb();
                Auther = AllBooks.get(i).getAuthorb();
                Year = AllBooks.get(i).getYearB();
                ISBN = AllBooks.get(i).getIsbnb();
                imageLink = AllBooks.get(i).getImageName();
                //out.print("*****"+ISBN);
                //imageLink="http://1.bp.blogspot.com/-BtqHtq6Zq9w/UqMt2JBuduI/AAAAAAAAA10/xzeVErVd_Ek/s1600/Java%2BGenerics%2Band%2BCollections.jpg";
                %>
                <div id="EBimages">
                    <ul>
                        <li>
                            <div id="d1">
                                <img id="imBook"  src="<%=imageLink %> "width="150px" height="250px"  class="booImages" ><br>
                                
                                <form action="returnBook">
                                    <input type="hidden" value="<%=ISBN %>" name="ISBN">
                                    <input type="submit" class="RBottoun" value="Return Book"><br>
                                </form>
                              
                                    <button class="RBottoun" onclick="ExtendPeriod_II(<%=ISBN%>)">ExtendPeriod Book</button><br>
                                
                            </div>
                        </li>
                    </ul>
                </div>
            <%}
        }
    %>
</div>
    <!--
    <div id="BorrwoingInContainer">
        <span onclick="boBookX()" class="close" title="Close Modal">&times;</span>
        <form class="animate" action="borrowBook" method="post">
            <label>Borrowing period:</label><br><br>
            <input type="text" name="period" placeholder="Borrowing period" class="period"><br>
            <input type="text" hidden="" value="<%=ISBN %>" id="_ISBN" name="ISBN" placeholder="bookISBN" class="LognamePass">
            <input type="submit" value="Borrowe Book" id="Boorbutton" onclick="boBookX()">
        </form>
    </div>
            -->
    <div id="ExtendPeriodContainer">
        <span onclick="ExtendPeriodX()" class="close" title="Close Modal">&times;</span>
        <form class="animate" action="extendPeriod" method="post">
            <label>Extend period:</label><br><br>
            <input type="text" name="period" placeholder="Extend period" class="period"><br>
            <input type="text" hidden="" value="<%=ISBN %>" id="ISBNExtend" name="ISBN" placeholder="bookISBN" class="LognamePass">
            <input type="submit" value="Extend Perid" id="Boorbutton" onclick="ExtendPeriodX()">
        </form>
    </div>

    </body>
</html>
