package com.projects.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private int seatNo;
    private int rowNo;
    private int colNo;
    @ManyToOne
    private SeatType type;



}
