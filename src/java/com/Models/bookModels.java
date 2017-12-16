/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Models;

import connDB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




/**
 *
 * @author hussienalbared
 */
public class bookModels {
    private int isbnb;
    private int yearB;
    private String titleb;
    private String authorb;
    private String updaterb;
    private String imageLink;

    public bookModels(int isbnb, int yearB, String titleb, String authorb, String updaterb,String imageLink) {
        this.isbnb = isbnb;
        this.yearB = yearB;
        this.titleb = titleb;
        this.authorb = authorb;
        this.updaterb = updaterb;
        this.imageLink= imageLink;
    }

    public bookModels() {
        this.isbnb = -1;
        this.yearB = -1;
        this.titleb = "";
        this.authorb = "";
        this.updaterb = "";
        this.imageLink= "";
    }
    
    public ArrayList<bookModels> getallbooks() throws SQLException
    {
        
        Connection con=DBConnection.getActiveConnection();
        String query="select * from books where ISBN not in (select bookISBN from borrowedbook)";
      PreparedStatement stm=con.prepareStatement(query);
      ArrayList<bookModels> arr=new ArrayList<>();
      ResultSet rs=stm.executeQuery();
      while(rs.next())
      {
         arr.add(new bookModels(rs.getInt("ISBN"), rs.getInt("Publication_Year"),rs.getString("Title"),
                 rs.getString("Author"), rs.getString("LastUpdater"),rs.getString("imageName")));
          
          
      }
      
        return arr;
        
        
        
    }
    
    
    public void returnBook(String uEmail,int isbn)throws SQLException
    {
           Connection con=DBConnection.getActiveConnection();
           String query="delete from borrowedbook where userEmail=? and bookISBN=?";
              PreparedStatement stm=con.prepareStatement(query);
         stm.setString(1, uEmail);
               stm.setInt(2, isbn);
                stm.executeUpdate();
               stm.close();
               
    }
     public void extendPeriod(String uEmail,int isbn,int period) throws SQLException
     {
         Connection con=DBConnection.getActiveConnection();
         String query="update borrowedbook set period=? where userEmail=? and bookISBN=?";
         PreparedStatement stm=con.prepareStatement(query);
         int t=getPeriod(uEmail, isbn);
         stm.setInt(1,t+ period);
         stm.setString(2, uEmail);
         stm.setInt(3, isbn);
         stm.executeUpdate();
         stm.close();
  
     }
    
    
    public void addBook(String title,String author,int isbn,int year,String updater,String imLink  ) throws SQLException
    {
       
        Connection con=DBConnection.getActiveConnection();
        String qwery = "insert into books (ISBN,Title,Author,LastUpdater,Publication_Year,imageName) values(?,?,?,?,?,?)";
PreparedStatement stm=con.prepareStatement(qwery);
stm.setInt(1, isbn);
  stm.setString(2, title);
  stm.setString(3, author);
  stm.setString(4, updater);
  stm.setInt(5, year);
  stm.setString(6, imLink);
  stm.executeUpdate();
            
    }
    
    public ArrayList<bookModels> getAllBowrrodBooks(String email) throws SQLException{
        ArrayList<bookModels> array=new ArrayList<>();
        Connection con=DBConnection.getActiveConnection();
        String query="select * from books,borrowedbook where borrowedbook.bookISBN=books.ISBN and userEmail='"+email+"'";
        PreparedStatement stm=con.prepareStatement(query);
        ResultSet rs=stm.executeQuery();
        while(rs.next())
        {
           array.add(new bookModels(rs.getInt("ISBN"), rs.getInt("Publication_Year"),rs.getString("Title"),
                   rs.getString("Author"), rs.getString("LastUpdater"),rs.getString("imageName")));


        }

        return array;
    }
    
    public void UpdateBook(String title,String author,int isbn,int year,String updater,String imLink)throws SQLException
    {
        Connection con=DBConnection.getActiveConnection();
     String query="update  books set Author=? ,title =?,Publication_Year=?,LastUpdater=?,imageName=? where ISBN=?";
               PreparedStatement stm=con.prepareStatement(query);
               stm.setString(1, author);
               stm.setString(2, title);
               
              
                  stm.setInt(3, year);
               stm.setString(4, updater);
               stm.setString(5, imLink);
            
               stm.setInt(6, isbn);
               stm.executeUpdate();
               stm.close();
        
        
        
    }
    public void sendEmail(String rEmail,String sEmail,String subject,String body)throws SQLException
    {
        Connection con=DBConnection.getActiveConnection();
        String query="insert into email(recieverEmail,senderEmail,subject,body,dateSent) values(?,?,?,?,now() )";
               PreparedStatement stm=con.prepareStatement(query);
               stm.setString(1, rEmail);
               stm.setString(2, sEmail);
               stm.setString(3, subject);
               stm.setString(4, body);
               
               stm.executeUpdate();
               stm.close();
    }
    public void getLate(String senderEmail) throws SQLException
    {
         Connection con=DBConnection.getActiveConnection();
         String query="select userEmail from borrowedbook where Date_ADD(borrowdate,interval period day)<now()";
         PreparedStatement stm=con.prepareStatement(query);
       //  Date  date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    ResultSet rs= stm.executeQuery();
    while(rs.next())
    {
        
        String emeil=rs.getString("userEmail");
        sendEmail(emeil, senderEmail, "Librrary", "youare late in return book");
        
        
    }
        
        
    }
    public void borrowBook(String uEmail,int isbn,int period) throws SQLException
    {
        
         Connection con=DBConnection.getActiveConnection();
         String query="insert into borrowedbook(userEmail,bookISBN,period,borrowdate) values(?,?,?,now())";
               PreparedStatement stm=con.prepareStatement(query);
               stm.setString(1, uEmail);
               stm.setInt(2, isbn);
               stm.setInt(3, period);
               
               stm.executeUpdate();
               stm.close();
               
    }
     /*public void returnBook(String uEmail,int isbn)throws SQLException
    {
           Connection con=DBConnection.getActiveConnection();
           String query="delete from borrowedbook where userEmail=? and bookISBN=?";
              PreparedStatement stm=con.prepareStatement(query);
         stm.setString(1, uEmail);
               stm.setInt(2, isbn);
                stm.executeUpdate();
               stm.close();
               
    }
     public void extendPeriod(String uEmail,int isbn,int period) throws SQLException
     {
         Connection con=DBConnection.getActiveConnection();
         String query="update borrowedbook set period=? where userEmail=? and bookISBN=?";
         PreparedStatement stm=con.prepareStatement(query);
         int t=getPeriod(uEmail, isbn);
         stm.setInt(1,t+ period);
         stm.setString(2, uEmail);
         stm.setInt(2, isbn);
         stm.executeUpdate();
         stm.close();
        
         
         
     }*/
     public int getPeriod(String uEmail,int isbn)throws SQLException
     {  Connection con=DBConnection.getActiveConnection();
     String query="select period from borrowedbook where userEmail=? and bookISBN=?";
       PreparedStatement stm=con.prepareStatement(query);
     stm.setString(1, uEmail);
         stm.setInt(2, isbn);
         ResultSet rs=stm.executeQuery();
   while(rs.next())
   {
       return rs.getInt("period");
   }
   return 0;
     }

     
     public ArrayList<bookModels> searchByISBN(int isbn) throws SQLException
    {
        Connection con=DBConnection.getActiveConnection();
        PreparedStatement stm;
        String query="select * from books where ISBN=?";
        stm=con.prepareStatement(query);
        stm.setInt(1, isbn);
        ResultSet rs=stm.executeQuery();
        ArrayList<bookModels> books=new ArrayList<>();
        while(rs.next())
        {
            
             books.add(new bookModels(rs.getInt("ISBN"), rs.getInt("Publication_Year"),rs.getString("Title"),
                 rs.getString("Author"), rs.getString("LastUpdater"),rs.getString("imageName")));
          
            
        }
        return books;
    }
    
    public ArrayList<bookModels> searchByAuthor(String Author) throws SQLException
    {
        
         Connection con=DBConnection.getActiveConnection();
        PreparedStatement stm;
        String query="select * from books where Author=?";
        stm=con.prepareStatement(query);
        stm.setString(1, Author);
        ResultSet rs=stm.executeQuery();
        ArrayList<bookModels> books=new ArrayList<>();
        while(rs.next())
        {
            
             books.add(new bookModels(rs.getInt("ISBN"), rs.getInt("Publication_Year"),rs.getString("Title"),
                 rs.getString("Author"), rs.getString("LastUpdater"),rs.getString("imageName")));
          
            
        }
        return books;
    }
    
    public ArrayList<bookModels> searchByPublicationYear(int year) throws SQLException
    {
        
         Connection con=DBConnection.getActiveConnection();
        PreparedStatement stm;
        String query="select * from books where Publication_Year=?";
        stm=con.prepareStatement(query);
        stm.setInt(1, year);
        ResultSet rs=stm.executeQuery();
        ArrayList<bookModels> books=new ArrayList<>();
        while(rs.next())
        {
            
             books.add(new bookModels(rs.getInt("ISBN"), rs.getInt("Publication_Year"),rs.getString("Title"),
                 rs.getString("Author"), rs.getString("LastUpdater"),rs.getString("imageName")));
          
            
        }
        return books;
    }
     

    /**
     * @return the isbnb
     */
    public int getIsbnb() {
        return isbnb;
    }
    
    public String getImageName(){
        return this.imageLink;
    }

    /**
     * @param isbnb the isbnb to set
     */
    public void setIsbnb(int isbnb) {
        this.isbnb = isbnb;
    }

    /**
     * @return the yearB
     */
    public int getYearB() {
        return yearB;
    }

    /**
     * @param yearB the yearB to set
     */
    public void setYearB(int yearB) {
        this.yearB = yearB;
    }

    /**
     * @return the titleb
     */
    public String getTitleb() {
        return titleb;
    }

    /**
     * @param titleb the titleb to set
     */
    public void setTitleb(String titleb) {
        this.titleb = titleb;
    }

    /**
     * @return the authorb
     */
    public String getAuthorb() {
        return authorb;
    }

    /**
     * @param authorb the authorb to set
     */
    public void setAuthorb(String authorb) {
        this.authorb = authorb;
    }

    /**
     * @return the updaterb
     */
    public String getUpdaterb() {
        return updaterb;
    }

    /**
     * @param updaterb the updaterb to set
     */
    public void setUpdaterb(String updaterb) {
        this.updaterb = updaterb;
    }
}
