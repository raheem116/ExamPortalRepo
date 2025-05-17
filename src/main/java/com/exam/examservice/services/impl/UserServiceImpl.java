package com.exam.examservice.services.impl;

import com.exam.examservice.models.User;
import com.exam.examservice.models.UserRole;
import com.exam.examservice.repositories.RoleRepo;
import com.exam.examservice.repositories.UserRepo;
import com.exam.examservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;


    //checking and creating new user
    //if user already available we are throwing exception
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User byUsername = userRepo.findByUserName(user.getUserName());
        if(byUsername != null){
            System.out.println("user already available ");
            throw new Exception("user already available exception");
        }else {
            for (UserRole userRole : userRoles) {
                //saving roles in db per particular roles assigned to user
                roleRepo.save(userRole.getRole());
            }

            //getting all the user roles and adding them into set of user role
            user.getUserRoles().addAll(userRoles);
            byUsername = this.userRepo.save(user);


        }

        return byUsername;
    }

    @Override
    public User getUserByUserName(String name) {
        User byUserName = this.userRepo.findByUserName(name);
        if(byUserName == null || byUserName.getUserName().isEmpty()) {
            throw new ArithmeticException("user not available in db :: "+name);
        }
        return byUserName;
    }

    @Override
    public User updateUser(String userName,User user) {

        return userRepo.save(user);

    }

    @Override
    public void deleteUserById(Long userId) {
        this.userRepo.deleteById(userId);
    }


}
