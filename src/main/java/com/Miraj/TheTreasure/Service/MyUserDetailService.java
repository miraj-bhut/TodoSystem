package com.Miraj.TheTreasure.Service;

import com.Miraj.TheTreasure.Model.UserPrincipal;
import com.Miraj.TheTreasure.Model.Users;
import com.Miraj.TheTreasure.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(username);
        if(users == null){
            System.out.println("user not found!!");
            throw new UsernameNotFoundException("user not found!!");
        }

        return new UserPrincipal(users);
    }

    public Boolean addUser(Users users) {
        String hashPass = passwordEncoder.encode(users.getPassword());
        users.setPassword(hashPass);
        userRepo.save(users);
        return userRepo.existsById(users.getId());
    }
}
