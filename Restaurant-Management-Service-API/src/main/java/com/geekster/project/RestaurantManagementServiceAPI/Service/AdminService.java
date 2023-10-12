package com.geekster.project.RestaurantManagementServiceAPI.Service;

import com.geekster.project.RestaurantManagementServiceAPI.Model.Admin;
import com.geekster.project.RestaurantManagementServiceAPI.Repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IAdminRepo adminRepo;

    public Admin createAdmin(Admin admin) {
        admin.setCreatedAt(LocalDateTime.now());
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(Integer adminId, Admin updatedAdmin) {
        Admin existingAdmin = adminRepo.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));

        // Update admin fields based on your requirements
        existingAdmin.setAdminName(updatedAdmin.getAdminName());
        existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
        // Update other fields as needed

        return adminRepo.save(existingAdmin);
    }

    public void deleteAdmin(Integer adminId) {
        Admin existingAdmin = adminRepo.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));

        adminRepo.delete(existingAdmin);
    }

    public Admin getAdminById(Integer adminId) {
        return adminRepo.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }
}

