package com.bhautik.bsm.security;

import com.bhautik.bsm.entitys.User;
import com.bhautik.bsm.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Optional<User> optional= userRepository.findByEmail(username);
       if (optional.isEmpty())
           throw new UsernameNotFoundException("User not FoundById");

       User user =optional.get();
       return org.springframework.security.core.userdetails.User.builder()
               .username(user.getEmail())
               .password(user.getPassword())
               .build();


    }
}
