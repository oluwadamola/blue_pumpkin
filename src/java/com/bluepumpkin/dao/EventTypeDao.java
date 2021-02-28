/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.dao;

import com.bluepumpkin.entity.Event;
import com.bluepumpkin.entity.EventType;
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
public class EventTypeDao implements EventTypeDaoLocal {
    @PersistenceContext(unitName = "BluePumpkinPU")
    EntityManager em;
    
    @Override
    public List<EventType> getEventTypes() {
        return em.createNamedQuery("EventType.all", EventType.class).getResultList();
    }

    @Override
    public EventType getEventType(int eventTypeId) {
      TypedQuery<EventType> query =  em.createNamedQuery("EventType.findById", EventType.class);
      return query.setParameter("eventTypeId", eventTypeId).getSingleResult();      
    }
   
}
