package com.Brayan_Vargas.taller1.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.Brayan_Vargas.taller1.dao.UserrDAO;
import com.Brayan_Vargas.taller1.model.Userr;
import com.Brayan_Vargas.taller1.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class MyCustomUserDetailsService implements UserDetailsService {

   // private final UserrRepository user;
   private final UserrDAO user;

    @Autowired
    public MyCustomUserDetailsService(UserrDAO user) {
        this.user = user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userr userr = user.findByName(username).get(0);
       // System.out.println(userr.getPerson().getPersonRoles().get(0).getRolee().getRoleName());
        if (userr != null) {

            //tubería
            User.UserBuilder builder = User.withUsername(username).password(userr.getUserPassword()).roles(userr.getPerson().getPersonRoles().get(0).getRolee().getRoleName()) ;
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
