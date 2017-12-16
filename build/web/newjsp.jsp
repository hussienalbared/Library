<%-- 
    Document   : newjsp
    Created on : Dec 22, 2016, 9:00:31 PM
    Author     : AG
--%>

<%@page import="com.Models.userModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Models.bookModels"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String Title,Auther,updater,imageLink;
    int Year,ISBN=0;
    /*userModel user = (userModel)session.getAttribute("activeuser");*/
    updater = "amr@h";
%>

<html>
    <head>
        <title>Library System_I</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <script src="myJs.js"></script>
        <style>
            #InputContainerISBN,#InputContainerAuthor,#InputContainerYear{border-radius: 4px;background-color: #E5E0C7;display: none;width: 300px;height: 170px;padding: 40px;position: fixed;z-index: 1;left: 0;top: 0; margin-left: 550px;margin-top: 160px;padding: 40px;z-index: 1;left: 0;top: 0;overflow: auto;}
            .INputContainerAll{border-radius: 4px;background-color: #E5E0C7;display: none;width: 300px;height: 170px;padding: 40px;position: fixed;z-index: 1;left: 0;top: 0; margin-left: 550px;margin-top: 160px;padding: 40px;z-index: 1;left: 0;top: 0;overflow: auto;}
            #popUpAddeBookContainer{padding-left: 40px;text-align: center; border-radius: 4px;background-color: #E3E7E8;display: none;width: 330px;height: 450px;padding: 40px;position: fixed;z-index: 1;left: 0;top: 0; margin-left: 550px;margin-top: 160px;padding: 0px;z-index: 1;left: 0;top: 0;overflow: auto;padding-left: 20px}
            #BorrwoingInContainer{padding-top: 0 ;border-radius: 4px;background-color: #E3E7E8;display: none;width: 310px;height: 210px;position: fixed;z-index: 1;left: 0;top: 0; margin-left: 550px;margin-top: 160px;z-index: 1;left: 0;top: 0;overflow: auto;}
            #Boorbutton{margin-bottom: 0}
            #popUpUpdateBookContainer{text-align: center; border-radius: 4px;background-color: #E3E7E8;display: none;width: 380px;height: 420px;padding: 40px;position: fixed;z-index: 1;left: 0;top: 0; margin-left: 550px;margin-top: 160px;padding: 0px;z-index: 1;left: 0;top: 0;overflow: auto;padding-left: 20px}
            #Updatebook{margin-bottom: 0}

        </style>
        <script>
            function popUpUpdateBookContainer(){
//                document.getElementById("tb").value=t;
//                document.getElementById("_ISBN").value=_src;
                document.getElementById("popUpUpdateBookContainer").style.display="block";
                document.getElementById("All").style.opacity=0.3;
            }
        </script>
    </head>
    <body>
         <%
            userModel user=(userModel) session.getAttribute("activeuser");
            int y = user.getType();
            String homeLink = y==1 ? "newjsp.jsp" : "studenthome.jsp" ;
            
        %>
        <div id="backGround">
                <div id="header">
                    <ul>
                       <li><a href="#" id="logo"><img src="images/bookSite.jpg" width="130" height="70"></a></li>
                       <li id="home"><a href="<%=homeLink %>">home</a></li>
                        <li id="item"><a href="SendEmail">sendEmail</a></li>
                        <li id="item" onclick="popUpAddeBookContainer()"><a href="#">AddBook</a></li>
                        <li><a href="userProfile.jsp">My Account</a></li>
                        <!--<li id="user" class="dropdown">
                            <a href="#" class="dropbtn">userName</a>
                            <div class="dropdown-content">
                                <a href="userProfile.jsp">My Account</a>
                                <a href="#">LogOut</a>
                                <a href="#">Link 3</a>
                            </div>
                        </li>-->
                    </ul>
                </div>
                <br>
                <!--<div id="container">
                    <p>Search & Browse Books</p>
                    <form class="form_" action="#">
                        <input type="search" placeholder="Search For Books..." required="">
                        <button class="search" type="submit">
                    </form>
                </div>-->
        </div>
        <%
    ArrayList<bookModels> AllBooks= null ;
    AllBooks=(ArrayList<bookModels>) session.getAttribute("AllBooks");
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
                            <img id="imBook"  src="<%=imageLink %>" width="150px" height="250px" onclick="popUpUpdateBookContainer()" class="booImages" title="Update book" ><br>
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
                    <input type="text" name="bookNamename" placeholder="<%=AllBooks.get(i).getTitleb()%>" class="LognamePass" id="tb">
                    <input type="text" id="_ISBN" name="ISBN" placeholder="<%=AllBooks.get(i).getIsbnb()%>" class="LognamePass">
                    <input type="text" name="Author" placeholder=<%=AllBooks.get(i).getAuthorb()%> class="LognamePass">
                    <input type="text" name="imageLink" placeholder="imageLink" class="LognamePass">
                    <input type="text" name="puplicationYear" placeholder=<%=Year %> class="LognamePass">
                    <input type="submit" value="Update Book" id="Updatebook">
                </form>
            </div>   
        <%}
    }
%>

    <div id="popUpAddeBookContainer">
        <span onclick="popUpAddeBookContainerX()" class="close" title="Close Modal">&times;</span>
        <h2 id="AddBookHeader">Add Book</h2>
        <form class="animate" action="addNewBook">
            <input type="text" name="bookNamename" placeholder="bookname" class="LognamePass">
            <input type="text" name="ISBN" placeholder="bookISBN" class="LognamePass">
            <input type="text" name="Author" placeholder="bookauther" class="LognamePass">
            <input type="text" name="puplicationYear" placeholder="puplicationyear" class="LognamePass">
            <input type="text" name="imageLink" placeholder="imageLink" class="LognamePass">
            <input type="submit" value="Add Book" id="Updatebook">
        </form>
    </div>

<!--===========================================================================-->
<div id="LibraryCategories">
    <ul>
        <li id="LibraryCatItem" class="dropdown">
            <h2 class="dropbtn">Search <img src="images/icon-arrow-down-b-128.png" width="20px" height="20px" id="arrowImg" title="Update book"></h2>
            <div class="dropdown-content">
                <a href="#" onclick="InputContainer(1)">ISBN</a>
                <a href="#" onclick="InputContainer(2)">Publication year</a>
                <a href="#" onclick="InputContainer(3)">Author</a>
            </div>
        </li>
    </ul>
</div>
<!--===========================================================================-->

<div id="InputContainerISBN" class="INputContainerAll">
    <span onclick="InputContainerX()" class="close" title="Close Modal">&times;</span>
    <form class="animate" action="searchByISBN">
        <label>Enter Criteria Value:</label><br><br>
        <input type="number" required name="cretairea" placeholder="ISBN Criteria Value" class="period"><br>
        <input type="submit" value="Search Book" id="Boorbutton">
    </form>
</div>
<div id="InputContainerAuthor" class="INputContainerAll">
    <span onclick="InputContainerX()" class="close" title="Close Modal">&times;</span>
    <form class="animate" action="searchByAuthor">
        <label>Enter Criteria Value:</label><br><br>
        <input type="text" required name="cretairea" placeholder="Author Criteria Value" class="period"><br>
        <input type="submit" value="Search Book" id="Boorbutton">
    </form>
</div>
<div id="InputContainerYear" class="INputContainerAll">
    <span onclick="InputContainerX()" class="close" title="Close Modal">&times;</span>
    <form class="animate" action="searchByYear">
        <label>Enter Criteria Value:</label><br><br>
        <input type="number" required name="cretairea" placeholder="Year Criteria Value" class="period"><br>
        <input type="submit" value="Search Book" id="Boorbutton">
    </form>
</div>
    </body>
</html>
