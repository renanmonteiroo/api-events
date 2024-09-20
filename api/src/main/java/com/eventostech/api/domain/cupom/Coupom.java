package com.eventostech.api.domain.cupom;

import com.eventostech.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "coupom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupom {

    @Id
    @GeneratedValue
    private UUID id;
    private String code;

    private Integer discount;
    private Date date;

    @ManyToOne
    @JoinColumn (name = "event_id")
    private Event event;
}
