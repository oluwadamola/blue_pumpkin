/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.dao;

import com.bluepumpkin.entity.Event;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface EventDaoLocal {
    void addEvent(Event event);
    Event getEvent(int eventId);
    List<Event> getEvents();
    void deleteEvent(Event event);
    List<Event> getAllEventByName(String name);
    void updateEvent(Event event); 
    int count();
}
