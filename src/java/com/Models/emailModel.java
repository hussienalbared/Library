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
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author AG
 */
public class emailModel {
    
    private String recievEmail; 
    private String senderEmail ;
    private String subject;
    private String body;
    private Time time ;

    
    
    public ArrayList<emailModel> getMyEmails(String email) throws SQLException{
        ArrayList<emailModel> my_Inbox = new ArrayList<>();
        Connection con=DBConnection.getActiveConnection();
     String query="select * from email where recieverEmail=?";
       PreparedStatement stm=con.prepareStatement(query);
     stm.setString(1, email);
         
         ResultSet rs=stm.executeQuery();
         while(rs.next()){
             my_Inbox.add(new emailModel(rs.getString("recieverEmail"), rs.getString("senderEmail"), rs.getString("subject")
                     , rs.getString("body"), rs.getTime("dateSent")));
         }
        return my_Inbox;
    }
    
    
    public emailModel() {
    }

    public emailModel(String recievEmail, String senderEmail, String subject, String body, Time time) {
        this.recievEmail = recievEmail;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.body = body;
        this.time = time;
    }

    /**
     * @return the recievEmail
     */
    public String getRecievEmail() {
        return recievEmail;
    }

    /**
     * @param recievEmail the recievEmail to set
     */
    public void setRecievEmail(String recievEmail) {
        this.recievEmail = recievEmail;
    }

    /**
     * @return the senderEmail
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * @param senderEmail the senderEmail to set
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Time time) {
        this.time = time;
    }
    
    
    
}
