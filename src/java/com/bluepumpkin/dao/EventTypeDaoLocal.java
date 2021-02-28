/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluepumpkin.dao;

import com.bluepumpkin.entity.EventType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface EventTypeDaoLocal {
    public List<EventType> getEventTypes();
    public EventType getEventType(int eventTypeId);
}
