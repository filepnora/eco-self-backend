package com.codecool.filepnora.ecoself.repository;

import com.codecool.filepnora.ecoself.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
