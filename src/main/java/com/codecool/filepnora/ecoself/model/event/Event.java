package com.codecool.filepnora.ecoself.model.event;

import com.codecool.filepnora.ecoself.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
    
    private LocalDateTime date;

    //private Address address;

}
