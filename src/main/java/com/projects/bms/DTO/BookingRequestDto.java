package com.projects.bms.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class BookingRequestDto {
    Integer userId;
    Integer seatId;
    Integer showId;
    List<Integer> showSeatId;

}
