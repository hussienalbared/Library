<%-- 
    Document   : searchResult
    Created on : Dec 24, 2016, 11:56:37 AM
    Author     : AG
--%>

<%@page import="com.Models.userModel"%>
<%@page import="com.Models.bookModels"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="userProfileStyle.css">
        <title>JSP Page</title>
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
            <h1 id="account">Searched Result</h1>
        </div>
        
        <%
    ArrayList<bookModels> AllBooks= null ;
    AllBooks=(ArrayList<bookModels>) session.getAttribute("searchBooks");
    if(AllBooks==null || AllBooks.size()==0){
        %><h2 id="EB">No Avaliable Books</h2>
    <%}
    else{
        // Books found%>
        
        <!--END BackGround Design-->
        <div id="content">
            <h2 id="EB">Library Books</h2>
        </div>
        <%
        for(int i=0;i<AllBooks.size();i++){
            //out.print(AllBooks.get(i).getTitleb()+" ");
            Title = AllBooks.get(i).getTitleb();
            Auther = AllBooks.get(i).getAuthorb();
            Year = AllBooks.get(i).getYearB();
            ISBN = AllBooks.get(i).getIsbnb();
            imageLink = AllBooks.get(i).getImageName();
            String x= String.valueOf(ISBN);
            //out.print(x);
            //imageLink="http://1.bp.blogspot.com/-BtqHtq6Zq9w/UqMt2JBuduI/AAAAAAAAA10/xzeVErVd_Ek/s1600/Java%2BGenerics%2Band%2BCollections.jpg";
            %>
            <div id="EBimages">
                <ul>
                    <li>
                        <div id="d1">
                            <img id="imBook"  src="<%=imageLink %>"width="150px" height="250px" onclick="popUpUpdateBookContainer(<%=ISBN %>)" class="booImages" title="Update book"><br>
                            <button class="RBottoun" onclick="borrowBook1(<%=ISBN %>)">Borrow Book</button><br>
                            <button class="DBottoun">Download</button>
                        </div>
                    </li>
                </ul>
            </div>
                            
            <div id="BorrwoingInContainer">
                <span onclick="boBookX()" class="close" title="Close Modal">&times;</span>
                <form class="animate" action="borrowBook" method="post">
                    <label>Borrowing period:</label><br><br>
                    <input type="text" name="period" placeholder="Borrowing period" class="period"><br>
                    <input type="text" value="<%=AllBooks.get(i).getIsbnb() %>" id="borroIsbn" name="ISBN" placeholder="bookISBN" class="LognamePass">
                    <input type="submit" value="Borrowe Book" id="Boorbutton" onclick="boBookX()">
                </form>
            </div>

            <div id="popUpUpdateBookContainer">
                <span onclick="popUpUpdateBookContainerX()" class="close" title="Close Modal">&times;</span>
                <h2 id="updateBookHeader">Book Update</h2>
                <form class="animate" action="UpdateBook">
                    <input type="text" name="bookNamename" placeholder="bookname" class="LognamePass">
                    <input type="text" hidden="" value="<%=AllBooks.get(i).getIsbnb() %>" id="_ISBN" name="ISBN" placeholder="bookISBN" class="LognamePass">
                    <input type="text" name="Author" placeholder="bookauther" class="LognamePass">
                    <input type="text" name="imageLink" placeholder="imageLink" class="LognamePass">
                    <input type="text" name="puplicationYear" placeholder="puplicationyear" class="LognamePass">
                    <input type="submit" value="Update Book" id="Updatebook">
                </form>
            </div>   
        <%}
    }
%>

    <div id="popUpAddeBookContainer">
        <span onclick="popUpAddeBookContainerX()" class="close" title="Close Modal">&times;</span>
        <h2 id="updateBookHeader">Add Book</h2>
        <form class="animate" action="addNewBook">
            <input type="text" name="bookNamename" placeholder="bookname" class="LognamePass">
            <input type="text" name="ISBN" placeholder="bookISBN" class="LognamePass">
            <input type="text" name="Author" placeholder="bookauther" class="LognamePass">
            <input type="text" name="puplicationYear" placeholder="puplicationyear" class="LognamePass">
            <input type="text" name="imageLink" placeholder="imageLink" class="LognamePass">
            <input type="submit" value="Add Book" id="Updatebook">
        </form>
    </div>

<!--===========================================================================-
<div id="LibraryCategories">
    <ul>
        <li id="LibraryCatItem" class="dropdown">
            <h2 class="dropbtn">Search <img src="images/icon-arrow-down-b-128.png" width="20px" height="20px" id="arrowImg" title="Update book"></h2>
            <div class="dropdown-content">
                <a href="#" onclick="InputContainer()">ISBN</a>
                <a href="#" onclick="InputContainer()">Publication year</a>
                <a href="#" onclick="InputContainer()">Author</a>
            </div>
        </li>
    </ul>
</div>
<!--===========================================================================-

<div id="InputContainer">
    <span onclick="InputContainerX()" class="close" title="Close Modal">&times;</span>
    <form class="animate" action="searchByISBN">
        <label>Enter Criteria Value:</label><br><br>
        <input type="text" name="ISBN" placeholder="Criteria Value" class="period" ><br>
        <input type="submit" value="Search Book" id="Boorbutton" onclick="InputContainerX()">
    </form>
</div>
-->
    </body>
</html>
