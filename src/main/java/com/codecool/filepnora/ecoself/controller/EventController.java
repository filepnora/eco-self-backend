package com.codecool.filepnora.ecoself.controller;

import com.codecool.filepnora.ecoself.model.event.Event;
import com.codecool.filepnora.ecoself.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    private List<Event> getAllEvents(){
        return eventRepository.getAllEvents();
    }

    @GetMapping("/events/{id}")
    private Event getEventById(Long id){
        return eventRepository.getById(id);
    }


}
