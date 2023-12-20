package com.projects.bms.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{


    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    private Date bookeddate;
    @ManyToOne
    private User bookedbyuser;
    @ManyToOne
    private Show show;

    private int totalamount;
    @ManyToMany
    private List<ShowSeat> showseats;
    @OneToMany
    private List<Payment> payments;
    //private





}
