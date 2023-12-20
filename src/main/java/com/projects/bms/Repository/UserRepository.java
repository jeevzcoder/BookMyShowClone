package com.projects.bms.Repository;

import com.projects.bms.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Override
    Optional<User> findById(Integer integer);
    Optional<User> findByEmailId(String emailId);
    //save(String )
    User save(User user);


    //@Override
    //<S extends User> S save(S entity);
}
