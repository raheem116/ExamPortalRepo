package com.exam.examservice.controllers;

import com.exam.examservice.models.Role;
import com.exam.examservice.models.User;
import com.exam.examservice.models.UserRole;
import com.exam.examservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUserController(@RequestBody User user) throws Exception {

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");


        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(userRole);
        return this.userService.createUser(user, userRoleSet);

    }

    @GetMapping("/{username}")
    public User getUserController(@PathVariable String username)
    {
        return this.userService.getUserByUserName(username);
    }

    public User updateUserController(){
        return null;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserController(@PathVariable("userId") Long userId){
         this.userService.deleteUserById(userId);
         return ResponseEntity.ok("deleted Successfully");
    }

    // need to work on update details
    @PostMapping("/update")
    public User updateUserDetailsController(@RequestBody User updateUser){

        User userByUserName = userService.getUserByUserName(updateUser.getUserName());
        if (userByUserName != null && !userByUserName.getUserName().isEmpty() && !updateUser.getUserName().isEmpty()){
            System.out.println("fdsgfdgdfgdf");
            userByUserName = userService.updateUser(userByUserName.getUserName(),updateUser);
        }

        return userByUserName;
    }

}
