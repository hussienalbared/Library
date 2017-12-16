/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Models;

import connDB.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author AG
 */
public class userModel {
    private String Name;
    private String Email;
    private String Password;
    private int Type; // 1-> admin. 2-> user
    
    ResultSet RS = null;
    Statement Stmt = null;
    String line;
    
    PreparedStatement preState;
    
    public userModel login(String e,String p) throws SQLException
    {Connection con=DBConnection.getActiveConnection();
        Stmt = con.createStatement();
       
        line = "select * from users where email=? and password=?";
        preState= con.prepareStatement(line);
        preState.setString(1, e);
         preState.setString(2, p);
        RS = preState.executeQuery();
        while(RS.next())
        {
            
            return new userModel(RS.getString("name"), RS.getString("email"), 
                    RS.getString("password"),
                    RS.getInt("type"));
            
        }
       
        return null;
        
    }
    public boolean registeUser() throws SQLException{
        Connection con=DBConnection.getActiveConnection();
        Stmt = con.createStatement();
        
        line = "select * from users where email=?";
        preState= con.prepareStatement(line);
        preState.setString(1, this.Email);
        RS = preState.executeQuery();
        if(RS.next())
            return false;
        else{
            line = "insert into users(name,email,type,password) values(?,?,?,?)";

            preState = con.prepareStatement(line);
            preState.setString(1, this.Name);
            preState.setString(2, this.Email);
            preState.setInt(3, this.Type);
            preState.setString(4, this.Password);

            preState.executeUpdate();
            return true;
        }
    }
    
    public int checkUser(String e) throws SQLException{
         Connection con=DBConnection.getActiveConnection();
        Stmt = con.createStatement();
        
        line = "select * from users where email=?";
        
        preState = con.prepareStatement(line);
        preState.setString(1, e);
        RS = preState.executeQuery();
        while(RS.next())
            return 0;
        return 1;
    }
    
    public boolean updateUser(String email) throws SQLException{
     Connection con=DBConnection.getActiveConnection();
        Stmt = con.createStatement();
        
        line = "UPDATE users SET name = ?, email = ?, type = ?, password= ?  WHERE email = ?";
        preState = con.prepareStatement(line);
        preState.setString(1, this.Name);
        preState.setString(2, this.Email);
        preState.setInt(3, this.Type);
        preState.setString(4, this.Password);
        preState.setString(5, email);

        preState.executeUpdate();
        return true;
    }
    public userModel() {
        this.Name = "";
        this.Email = "";
        this.Password = "";
        this.Type = -1;
    }

    public userModel(String Name, String Email, String Password, int Type) {
        
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Type = Type;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Type
     */
    public int getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(int Type) {
        this.Type = Type;
    }
    
    
}
