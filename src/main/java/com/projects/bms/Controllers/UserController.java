package com.projects.bms.Controllers;

import com.projects.bms.DTO.SignUpUserRequestDto;
import com.projects.bms.DTO.SignUpUserResponseDto;
import com.projects.bms.Exception.UserNotFoundException;
import com.projects.bms.Models.User;
import com.projects.bms.Models.UserResponseStatus;
import com.projects.bms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

    SignUpUserResponseDto signUp(SignUpUserRequestDto requestDto) throws Exception {
        try {
            User user = userService.signUp(requestDto.getEmail(), requestDto.getPassword());
            SignUpUserResponseDto responseDto = new SignUpUserResponseDto();
            //responseDto.setUserId(user.getUserId());
            responseDto.setResponseStatus(UserResponseStatus.Present);
            return responseDto;
        } catch (Exception e) {
            throw new UserNotFoundException("User not found pls sign in");
        }
    }
        SignUpUserResponseDto logIn(SignUpUserRequestDto requestDto) throws Exception{
            User user =userService.signUp(requestDto.getEmail(),requestDto.getPassword());
            SignUpUserResponseDto responseDto=new SignUpUserResponseDto();
            //responseDto.setUserId(user.getId());
            responseDto.setResponseStatus(UserResponseStatus.Present);
            return responseDto;


        }



}
