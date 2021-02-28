/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author USER
 */

@Table(name="events")
@NamedQueries({
        @NamedQuery(name = "Event.all", query="SELECT e FROM Event e"),
        @NamedQuery(name ="Event.findByEmail", query="SELECT e from Event e where e.eventId = :email "),
        @NamedQuery(name ="Event.findByName", query="SELECT e.eventType.eventName from Event e where e.eventType.eventName = :eventName"),
        @NamedQuery(name ="Event.delete", query="DELETE FROM Event e where e.eventId =:userId")
})
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Event_Time")
    private Date eventTime; 
    
    @ManyToOne
    @JoinColumn(name = "eventTypeId")
    private EventType eventType;
        
    private String title;
    private String description;

    public Event() {
    }

    public Event(int eventId) {
        this.eventId = eventId;
    }
    

    public Event(int eventId, Date eventTime, EventType eventType, String title, String description) {
        this(eventId);
        this.eventTime = eventTime;
        this.eventType = eventType; 
        this.title = title;
        this.description = description;
    }

    public Event(Date eventTime, EventType eventtype,String title, String description) {
        this.eventTime = eventTime;
        this.eventType = eventtype;
        this.title = title;
        this.description = description;
    }
    
    

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
}
