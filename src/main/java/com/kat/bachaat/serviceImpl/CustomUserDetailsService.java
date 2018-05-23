package com.kat.bachaat.serviceImpl;

import com.kat.bachaat.dao.UserDAO;
import com.kat.bachaat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private  UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
