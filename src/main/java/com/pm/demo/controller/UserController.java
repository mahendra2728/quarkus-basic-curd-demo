package com.pm.demo.controller;

import com.pm.demo.model.User;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    @Transactional
    public String addUser(User user) {
        User.persist(user);
        return "User added successfully !";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return User.findAll().list();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return User.findById(id);
    }

    @PutMapping("/users/{id}")
    @Transactional
    public String updateUser(@PathVariable int id, User user) {
        if (Objects.nonNull(getUserById(id))) {
            User.deleteById(id);
            User.persist(user);
        } else {
            return "User not exists";
        }
        return "User updated successfully !";
    }

    @DeleteMapping("users/{id}")
    @Transactional
    public void deleteUser(@PathVariable int id) {
        User.deleteById(id);
        System.out.println(" User with id " + id + " deleted !");
    }

    @GetMapping("/users/search/{firstName}")
    public List<User> getUsersByFirstName(String firstName) {
        return User.getUserByFirstName(firstName);
    }

    @GetMapping("/users/search/keyword/{keyword}")
    public List<User> getUsersBySearchKeyword(String keyword) {
        return User.getUserByAlphabets(keyword);
    }


}
