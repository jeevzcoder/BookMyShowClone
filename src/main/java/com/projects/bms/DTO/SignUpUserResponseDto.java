package com.projects.bms.DTO;

import com.projects.bms.Models.UserResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpUserResponseDto {
    Integer userId;
    UserResponseStatus responseStatus;
}
