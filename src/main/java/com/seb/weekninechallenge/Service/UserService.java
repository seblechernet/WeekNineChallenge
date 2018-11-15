package com.seb.weekninechallenge.Service;

import com.seb.weekninechallenge.Model.AppUser;
import com.seb.weekninechallenge.Model.Role;
import com.seb.weekninechallenge.Repository.AppUserRepository;
import com.seb.weekninechallenge.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    RoleRepository roleRepository;

    public void saveUser(AppUser appUser) {
        Role role = roleRepository.findByRole("USER");
        appUser.setRoles(Arrays.asList(role));
        appUserRepository.save(appUser);


    }

}
