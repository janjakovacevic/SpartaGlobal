package com.sparta.engineering72.sakilaproject.securingweb;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Staff;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import com.sparta.engineering72.sakilaproject.respositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String anyUsername) throws UsernameNotFoundException {
        Customer customer = customerRepository.getCustomerByEmail(anyUsername);
        Staff staff = staffRepository.getStaffByUsername(anyUsername);

        User.UserBuilder builder;

        if(customer == null && staff == null) {
            throw new UsernameNotFoundException("Could not find user");
        } else {
            builder = User.withUsername(anyUsername);
            if(staff != null){
                builder.password(new BCryptPasswordEncoder().encode((staff.getPassword())));
                    builder.roles("ADMIN");
            } else {
                builder.password(new BCryptPasswordEncoder().encode(String.valueOf(customer.getCustomerId())));
                    builder.roles("USER");
            }
            return builder.build();
        }
    }
}
