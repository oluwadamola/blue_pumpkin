/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.servlet;

import com.bluepumpkin.dao.EventDaoLocal;
import java.io.IOException;
import java.util.Enumeration;
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
public class ManageServlet extends HttpServlet {
    @EJB
    EventDaoLocal eventdao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             int gamecount = eventdao.getAllEventByName("Games").size();
             int meetingcount = eventdao.getAllEventByName("Meeting").size();
             int competitioncount = eventdao.getAllEventByName("Competition").size();
             request.setAttribute("gamecount", gamecount);
             request.setAttribute("meetingcount", meetingcount);
             request.setAttribute("competitioncount", competitioncount);
             RequestDispatcher view= request.getRequestDispatcher("index.jsp");
             view.forward(request,response);
    }

}
