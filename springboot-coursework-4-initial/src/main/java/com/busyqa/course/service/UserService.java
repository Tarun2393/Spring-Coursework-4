package com.busyqa.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.busyqa.course.jpa.User;
import com.busyqa.course.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly=true)
    public Optional<User> findUser(int idUser){
        return this.userRepository.findById(idUser);
    }

    /*
     * The following method updates the User in DB. It takes the newUser
     * variable as a parameter; this newUser variable contains the information
     * sent by the front-end.
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public User updateUser(User newUser,int idUser){

        /*
         * The findById() method returns an Optional<User> object, then the map() method
         * grabs the User inside the Optional object and overwrites the old information
         * with the new data from the newUser variable, in this example, we need to use
         * the save() method to re-write the user entity with the new information into the DB.
         */

        return this.userRepository.findById(idUser)
                .map(user -> {

                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setUsername(newUser.getUsername());
                    user.setBirth(newUser.getBirth());

                    /*
                     * {3} Write a statement that updates the User in the DB by using the
                     *     this.userRepository.save() method. Note that you have to pass
                     *     User object as a parameter to the save() method.
                     */
                    this.userRepository.save(user);
                    return user; /* Replace the variable user with the statement that saves the user here */
                }).orElse(null);
    }
}
