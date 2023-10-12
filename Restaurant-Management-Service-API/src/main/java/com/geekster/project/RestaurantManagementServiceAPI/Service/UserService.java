package com.geekster.project.RestaurantManagementServiceAPI.Service;

import com.geekster.project.RestaurantManagementServiceAPI.DTO.SignUpOutput;
import com.geekster.project.RestaurantManagementServiceAPI.Model.User;
import com.geekster.project.RestaurantManagementServiceAPI.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;

    public SignUpOutput signUpUser(User user) {
        // Add validation logic if needed
        userRepo.save(user);
        return new SignUpOutput(true, "User registered successfully");
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    public User updateUser(Integer userId, User updatedUser) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Update user fields based on your requirements
        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setUserEmail(updatedUser.getUserEmail());
        existingUser.setUserPassword(updatedUser.getUserPassword());
        // Update other fields as needed

        return userRepo.save(existingUser);
    }

    public void deleteUser(Integer userId) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepo.delete(existingUser);
    }

    public User getUserById(Integer userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }



    }



