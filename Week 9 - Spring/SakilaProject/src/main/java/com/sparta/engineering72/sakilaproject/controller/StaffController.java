package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Staff;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import com.sparta.engineering72.sakilaproject.services.InventoryService;
import com.sparta.engineering72.sakilaproject.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StaffController {

    private StaffService staffService;
    private CustomerService customerService;
    private InventoryService inventoryService;
    @Autowired
    public StaffController(StaffService staffService, CustomerService customerService, InventoryService inventoryService) {
        this.staffService = staffService;
        this.customerService = customerService;
        this.inventoryService = inventoryService;
    }
    @GetMapping("/owner")
    public String currentUser(ModelMap modelMap, HttpServletRequest request) {
        String username = request.getRemoteUser();
        Staff staff = staffService.getStaffByUsername(username);
        Integer customerCount = customerService.getCustomerCount();
        Integer inventoryCount = inventoryService.getInventoryCount();
        modelMap.addAttribute("staff", staff);
        modelMap.addAttribute("customers", customerCount);
        modelMap.addAttribute("inventory", inventoryCount);
        return "/owner/owner";
    }
}
