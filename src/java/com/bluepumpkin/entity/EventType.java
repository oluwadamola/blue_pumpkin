/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author USER
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "EventType.all", query = "SELECT e from EventType e "),
    @NamedQuery(name ="EventType.findById", query="SELECT e from EventType e where e.eventTypeId = :eventTypeId")
})
public class EventType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventTypeId;
    private String eventName;
    @OneToMany(mappedBy = "eventType")
    private List<Event> events;

    public EventType() {
    }

    public EventType(int eventTypeId, String eventName) {
        this.eventTypeId = eventTypeId;
        this.eventName = eventName;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    
}
