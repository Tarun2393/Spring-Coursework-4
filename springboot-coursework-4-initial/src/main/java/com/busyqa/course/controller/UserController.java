package com.busyqa.course.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyqa.course.jpa.User;
import com.busyqa.course.service.UserService;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id") int id) {

        logger.debug("Find User");

        Optional<User> opt = this.userService.findUser(id);

        if (opt.isPresent()){
            logger.info("User Found !!! - {}", opt.get());
        } else {
            logger.info("User Not Found : {}",id);
        }

        return opt.orElse(null);
    }

    /*
     * The following method updates the user's information in the DB.
     *
     * For {3}:
     * In the previous projects we used the @PostMapping annotation on methods that update
     * information in the DB, but usually, when working with Rest WebServices, methods that
     * update information are annotated with @PutMapping.
     *
     * For {4}
     * This method receives the information of the user in a String in JSON format. In this
     * situation the @RequestBody annotation is very handy because it breaks down the JSON
     * and populates the object annotated automatically.
     */

    /* {3} Add the @PutMapping annotation here, pass "/users/{id}" as a parameter. */
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") int id){

        logger.debug("Update User");

        return this.userService.updateUser(user,id);
    }
}
