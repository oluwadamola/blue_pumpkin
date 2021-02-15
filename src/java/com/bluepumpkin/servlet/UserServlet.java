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
import javax.servlet.ServletException;
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
   User user;
   List<User> users;
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();    
        switch(action){
            case "/UserServlet/add":
                 insertUser(request, response);
                 break;                
            case "/UserServlet/update":
                updateUser(request,response);
                break;
            case "/UserServlet/delete":
                deleteUser(request, response);
                break;
            case "/UserServlet/edit":
                showEditForm(request, response);
                break;
            case "/UserServlet/new":
                showNewForm(request,response);
                break;
            default:
                listUser(request, response);
                break;
       }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        users = userdao.getUsers();
        rd = request.getRequestDispatcher("/userlist.jsp");
        request.setAttribute("users", users);
        request.setAttribute("usercount", users.size());
        rd.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        user = new User();
        user = userdao.getUser(userId);
        userdao.deleteUser(user);
        listUser(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        user = new User(firstName, lastName, email, phoneNumber, password, address);
        userdao.updateUser(user);
        listUser(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber"); 
        String address = request.getParameter("address");
        user = new User(firstName, lastName, email, phoneNumber, password, address);
        if(userdao.getUserByEmail(email) == null){
            userdao.addUser(user);
            users = userdao.getUsers();
            listUser(request, response);
        }
        else{
            request.setAttribute("email_taken", "Email is already taken");
            rd = request.getRequestDispatcher("/createuser.jsp");
            rd.forward(request, response);
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         RequestDispatcher dispatcher = request.getRequestDispatcher("/edituser.jsp");
         int userId = Integer.parseInt(request.getParameter("userId"));
         user = userdao.getUser(userId);
         request.setAttribute("user", user);
         dispatcher.forward(request, response);
      }
        private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rd = request.getRequestDispatcher("/createuser.jsp");
        rd.forward(request, response);
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
