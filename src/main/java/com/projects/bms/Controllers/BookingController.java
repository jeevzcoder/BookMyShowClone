package com.projects.bms.Controllers;

import com.projects.bms.DTO.BookingRequestDto;
import com.projects.bms.DTO.BookingResponseDto;
import com.projects.bms.Models.Booking;
import com.projects.bms.Service.BookingService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Getter
@Setter
@RestController
@RequestMapping("/Booking")
public class BookingController {
    BookingService bookingService;
    //1. Select the seat List of seats with ID
    //2. check the status of seats
    //3. if available lock the seats
    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    @PostMapping("/book/{requestDto}")
    BookingResponseDto bookMovie(@PathVariable("requestDto") BookingRequestDto requestDto) throws Exception{

        Booking booking=bookingService.bookMovie(requestDto.getUserId(), requestDto.getShowId(),requestDto.getShowSeatId());
        return new BookingResponseDto();

    }
}
