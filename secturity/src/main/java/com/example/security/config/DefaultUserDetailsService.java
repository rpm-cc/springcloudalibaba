package com.example.security.config;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author   rpmcc
 * @date     2019/2/19
 * @description    msg
 * @version 1.0
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username=="renpiming") {
            DefaultUser defaultUser = new DefaultUser();
            System.out.println("user detailservice  ！");
            return defaultUser;
        }
        return null;
    }


}
