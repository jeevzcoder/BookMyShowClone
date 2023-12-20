package com.projects.bms.Service;

import com.projects.bms.Exception.UserNotFoundException;
import com.projects.bms.Models.User;
import com.projects.bms.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    public User signUp(String email, String passWord) throws Exception{
        Optional<User> optionalUser=userRepository.findByEmailId(email);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User already present login");
        }
            User user=new User();
            user.setEmail(email);

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(passWord));

            userRepository.save(user);

        return user;
        }




    public User logIn(String email, String passWord) throws Exception{
       Optional<User> optionalUser=userRepository.findByEmailId(email);
       if (optionalUser.isEmpty()){
            throw new UserNotFoundException("User not Exist pls Signup");
        }
       User user=optionalUser.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(passWord, user.getPassword())) {
            throw new UserNotFoundException("Wrong Password");
        }


       return user;
    }

}
