/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.Models.bookModels;
import com.Models.userModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hussienalbared
 */
public class addNewBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
        bookModels b=new bookModels();
        String title=request.getParameter("bookNamename");
        String author=request.getParameter("Author");
        int isbn=Integer.parseInt(request.getParameter("ISBN"));
        int year=Integer.parseInt(request.getParameter("puplicationYear"));
        String imageLink = request.getParameter("imageLink");
       
        PrintWriter out = response.getWriter();
        //out.print("title= "+title+ ",  Author="+author+ ", ISBN="+isbn+ " Year="+year+", ImageLink="+imageLink);
        
        HttpSession s = request.getSession(true);
        userModel user = (userModel) s.getAttribute("activeuser");
        
        String updater=user.getEmail();
        //out.print("****"+updater);
        b.addBook(title, author, isbn, year, updater,imageLink);
        
        
        bookModels book = new bookModels();
        ArrayList<bookModels>allBooks = book.getallbooks();
        
        HttpSession session = request.getSession(true);
        session.setAttribute("AllBooks", allBooks);
        
        response.sendRedirect("newjsp.jsp");
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addNewBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addNewBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
