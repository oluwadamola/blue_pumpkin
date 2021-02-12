/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.servlet;

import com.bluepumpkin.dao.UserDaoLocal;
import com.bluepumpkin.entity.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class UserServlet extends HttpServlet {
   @EJB
   UserDaoLocal userdao;
   RequestDispatcher rd;
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        
        User user = new User(firstName, lastName, email, phoneNumber, password);
        List<User> users;
        users = userdao.getUsers();
        switch(action){
            case "/UserServlet/add":
                if(userdao.getUserByEmail(email) == null){
                    userdao.addUser(user);
                    users = userdao.getUsers();
                    rd = request.getRequestDispatcher("/userlist.jsp");                    
                    request.setAttribute("users", users);
                    request.setAttribute("usercount", users.size());
                    rd.forward(request, response);
                }
                else{         
                    request.setAttribute("email_taken", "Email is already taken");
                    rd = request.getRequestDispatcher("/createuser.jsp");
                    rd.forward(request, response);
                }
                break;
                
            case "/UserServlet/update":
                userdao.updateUser(user);
                request.setAttribute("users", users);
                request.getRequestDispatcher("/userlist.jsp").forward(request, response);
                break;
            case "/delete":
                int userId = Integer.parseInt(request.getParameter("userId"));
                userdao.deleteUser(userId);
                request.setAttribute("users", users);
                request.getRequestDispatcher("userlist.jsp").forward(request, response);
                break;
            default:
                users = userdao.getUsers();
                rd = request.getRequestDispatcher("userlist.jsp");
                request.setAttribute("users", users);
                request.setAttribute("usercount", users.size());
                rd.forward(request, response);
                break;
       }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
