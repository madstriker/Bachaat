package com.kat.bachaat.serviceImpl;

import com.kat.bachaat.dao.UserDAO;
import com.kat.bachaat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@Service("loginService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private  UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        userDAO.saveUser(new User( "admin","admin","admin",
 passwordEncoder.encode("admin"),"admin@yahoo.com","ptn",500,91831313L
        ));
        User user1=userDAO.getUserByUserName(username);
        if(user1==null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user1.getFirstName(),user1.getPassword(),getAuthority());
    }

    private List getAuthority(){
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
