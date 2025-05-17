package com.exam.examservice.services;

import com.exam.examservice.models.User;
import com.exam.examservice.models.UserRole;

import java.util.Set;
public interface UserService {
    //to create a user in db
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //get user by username
    public User getUserByUserName(String name);
    //update user details based on id
    public User updateUser(String userName,User user);
    //delete user by id'
    public void deleteUserById(Long userId);
}
