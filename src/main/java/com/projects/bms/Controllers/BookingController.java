package com.projects.bms.Controllers;

import com.projects.bms.DTO.BookingRequestDto;
import com.projects.bms.DTO.BookingResponseDto;
import com.projects.bms.Models.Booking;
import com.projects.bms.Service.BookingService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Getter
@Setter
@Controller
public class BookingController {
    BookingService bookingService;
    //1. Select the seat List of seats with ID
    //2. check the status of seats
    //3. if available lock the seats
    //4.\
    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    BookingResponseDto bookMovie(BookingRequestDto requestDto) throws Exception{
        //BookingResponseDto responseDto= new BookingResponseDto();
        Booking booking=bookingService.bookMovie(requestDto.getUserId(), requestDto.getShowId(),requestDto.getShowSeatId());
        return new BookingResponseDto();

    }
}
