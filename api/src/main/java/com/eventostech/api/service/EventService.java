package com.eventostech.api.service;

import com.eventostech.api.domain.event.Event;
import com.eventostech.api.domain.event.EventRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class EventService {
    public Event createEvent(EventRequestDTO data){
        String imgUrl = null;

        if(data.image() != null){
           imgUrl = this.uploadImg(data.image());
        }
        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setEventUrl(imgUrl);

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartFile){
        return"";
    }
}
