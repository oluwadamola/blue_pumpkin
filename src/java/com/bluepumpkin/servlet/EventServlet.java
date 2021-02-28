/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.servlet;

import com.bluepumpkin.dao.EventDaoLocal;
import com.bluepumpkin.dao.EventTypeDaoLocal;
import com.bluepumpkin.entity.Event;
import com.bluepumpkin.entity.EventType;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class EventServlet extends HttpServlet {
   @EJB
   EventDaoLocal eventdao;
   @EJB
   EventTypeDaoLocal eventTypedao;
   
   RequestDispatcher rd;
   Event event;
   EventType eventType;
   List<Event> events;
   List<EventType> eventTypes;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath(); 
        switch(action){
            case "/EventServlet/add":
                 insertEvent(request, response);
                 break;                
            case "/EventServlet/update":
                updateEvent(request,response);
                break;
            case "/EventServlet/delete":
                deleteEvent(request, response);
                break;
            case "/EventServlet/edit":
                showEditForm(request, response);
                break;
            case "/EventServlet/new":
                showNewForm(request,response);
                break;
            default:
                listEvent(request, response);
                break;
       }
    }

    
    private void insertEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        try {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String eventtime = request.getParameter("date");
            int eventtypeId = Integer.parseInt(request.getParameter("eventtype"));          
            eventType = eventTypedao.getEventType(eventtypeId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date eventdate = sdf.parse(eventtime);
            event = new Event();
            event.setTitle(title);
            event.setEventTime(eventdate);
            event.setDescription(description);
            event.setEventType(eventType);
            eventdao.addEvent(event);
            listEvent(request, response);
        } catch (NumberFormatException | ParseException | ServletException ex) {
        } catch (IOException ex) {
            Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) {
//       try {
//           String description = request.getParameter("description");
//           String eventtime = request.getParameter("eventtime");
//           String eventtype = request.getParameter("eventtype");
//           String title = request.getParameter("title");
//           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//           Date eventdate = sdf.parse(eventtime);
//           event = new Event(eventdate, eventType, title, description);
//           eventdao.updateEvent(event);
//           listEvent(request, response);
//       } catch (ParseException ex) {
//           Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
//       }
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        event = new Event();
        event = eventdao.getEvent(eventId);
        eventdao.deleteEvent(event);
        listEvent(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         rd  = request.getRequestDispatcher("/admin/editevent.jsp");
         int eventId = Integer.parseInt(request.getParameter("eventId"));
         event = eventdao.getEvent(eventId);
         request.setAttribute("event", event);
         rd.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rd = request.getRequestDispatcher("/admin/createevent.jsp");
        eventTypes = eventTypedao.getEventTypes();
        request.setAttribute("eventtypes", eventTypes);
        rd.forward(request, response);
    }

    private void listEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        events = eventdao.getEvents();
        rd = request.getRequestDispatcher("/admin/eventlist.jsp");
        request.setAttribute("events", events);
        request.setAttribute("eventscount", events.size());
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
