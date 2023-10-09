package com.geekster.weeklyTest.project.RestaurantManagementApplication.Service;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Admin;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.DTO.SignUpOutput;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Repository.IAdminRepo;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.HashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    IAdminRepo iAdminRepo;
    public SignUpOutput addAdmin(Admin admin) {
        String email = admin.getAdminEmail();

        String signUpStatusMessage = "";
        if(email==null)
        {
            signUpStatusMessage = "Enter a Valid Email";
            return new SignUpOutput(false,signUpStatusMessage);
        }

        Admin existingAdmin = iAdminRepo.findFirstByAdminEmail(email);

        if(existingAdmin!=null)
        {
            signUpStatusMessage = "Email Already Registered";
            return  new SignUpOutput(false ,signUpStatusMessage );
        }

        try {
            String encryptPass = PasswordEncrypter.encryptPassword(admin.getAdminPassword());
            admin.setAdminPassword(encryptPass);
            iAdminRepo.save(admin);

            signUpStatusMessage = "New Admin Registered";

            return new SignUpOutput(true,signUpStatusMessage);
        }
        catch (Exception e)
        {
            signUpStatusMessage = "Internal error occurred ";

            return new SignUpOutput(false,signUpStatusMessage);
        }

    }

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_


    public boolean ifAdminExistOrNot(String adminEMail) {
        Admin existingAdmin = iAdminRepo.findFirstByAdminEmail(adminEMail);

        return existingAdmin!=null;
    }
}
