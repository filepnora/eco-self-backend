package com.codecool.filepnora.ecoself.repository;

import com.codecool.filepnora.ecoself.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e")
    List<Event> getAllEvents();

    Event getById(Long id);
}
