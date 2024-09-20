package com.eventostech.api.domain.Adress;

import com.eventostech.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table (name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    private String uf;

    private String city;

    @ManyToMany
    @JoinColumn ( name = "event_id")
    private Event event;
}
