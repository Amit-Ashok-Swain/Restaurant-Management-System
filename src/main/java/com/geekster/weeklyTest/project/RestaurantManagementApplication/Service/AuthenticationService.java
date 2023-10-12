package com.geekster.weeklyTest.project.RestaurantManagementApplication.Service;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.AuthenticationToken;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo iAuthenticationRepo;

    public void saveAuthToken(AuthenticationToken auth) {
        iAuthenticationRepo.save(auth);
    }

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = iAuthenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }
}

// Coded by: Amit Ashok Swain
// GitHub - amitashokswain
// E-mail - business.amitswain@gmail.com
// Instagram - _sanatani_hindutwa_