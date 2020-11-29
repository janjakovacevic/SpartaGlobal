package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Staff;
import com.sparta.engineering72.sakilaproject.respositories.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public Staff getStaffByUsername(String username){
        return staffRepository.getStaffByUsername(username);
    }
}
