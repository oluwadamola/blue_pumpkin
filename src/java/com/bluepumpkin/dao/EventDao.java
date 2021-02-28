/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.dao;

import com.bluepumpkin.entity.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author USER
 */
@Stateless
public class EventDao implements EventDaoLocal {
    @PersistenceContext(unitName = "BluePumpkinPU")
    private EntityManager em;
    
    @Override
    public void addEvent(Event event) {
        em.persist(event);
    }

    @Override
    public Event getEvent(int eventId) {
        return em.find(Event.class, eventId);
    }
    @Override
    public List<Event> getEvents() {
        return em.createNamedQuery("Event.all", Event.class).getResultList();
    }
    @Override
    public void deleteEvent(Event event){
       if(!em.contains(event)){
           event = em.merge(event);
       }
       em.remove(event);
    }
    @Override
    public void updateEvent(Event event) {
        em.merge(event);
    }
   
    @Override
    public int count(){
        return getEvents().size();
    }

    @Override
    public List<Event> getAllEventByName(String name) {
      TypedQuery<Event> query =  em.createNamedQuery("Event.findByName", Event.class);
      return query.setParameter("eventName", name).getResultList();  
    }
}
