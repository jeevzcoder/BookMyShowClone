package com.projects.bms.Service;

import com.projects.bms.Exception.ShowNotFoundException;
import com.projects.bms.Exception.ShowSeatNotFoundException;
import com.projects.bms.Exception.UserNotFoundException;
import com.projects.bms.Models.*;
import com.projects.bms.Repository.ShowRepository;
import com.projects.bms.Repository.ShowSeatRepository;
import com.projects.bms.Repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service

public class BookingService {
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    UserRepository userRepository;


    @Autowired
    public BookingService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, UserRepository userRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        //this.seatRepository=seatRepository;
    }

    //@Transactional(isolation=Isolation.SERIALIZABLE)
   //@Transactional()
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Integer userId, Integer showId, List<Integer> showSeatIds) throws Exception{
        //check id seat and show and show seats available
        //if not available throw exception
        //if available lock the seat
        //change the status to blocked
        //remove the lock
        // direct to payment page
        // if status successful change the status to booked
        //if not change the status to available after 15 min

        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User Doesn't exist");
        }
        User user=optionalUser.get();

        Optional<Show> optionalShow= showRepository.findById(showId);
        // show.
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("Show doesn't Exist");
        }
        Show show=optionalShow.get();

        //implementation can be  different
       // Optional<List<ShowSeat>> optionalShowSeats= Optional.of(showSeatRepository.findAllById(showSeatIds));
        //if (optionalShowSeats.isEmpty()){
       //     throw new ShowSeatNotFoundException("Show Seat Not Found");
        //}

        //-----------------------LOCK---------------------------------

        List<ShowSeat> showSeats=showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.Available)){
                throw new ShowSeatNotFoundException("Show Seat is Blocked");
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.Blocked);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        //------------------------Unlock--------------------------------------

        //Check for the payment and status

        Booking booking =new Booking();
        booking.setBookedbyuser(user);
        booking.setShow(show);
        booking.setBookeddate(new Date());
        booking.setStatus(BookingStatus.Booked);
        booking.setTotalamount(200);
        booking.setShowseats(savedShowSeats);
        //booking.setAmount(priceCalculator.calculatePrice(bookedShow, savedShowSeats));
        return booking;









    }
}
