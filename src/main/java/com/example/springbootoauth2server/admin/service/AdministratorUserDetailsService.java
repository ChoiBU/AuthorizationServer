package com.example.springbootoauth2server.admin.service;

import com.example.springbootoauth2server.admin.entity.Administrator;
import com.example.springbootoauth2server.admin.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorUserDetailsService implements UserDetailsService {

    private final AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUsername(username);
        if (administrator == null) {
            throw new UsernameNotFoundException(username + "is not found.");
        }

        // TODO: 권한 넣어주기
        List<GrantedAuthority> authorities = new ArrayList<>();
        // TODO: test
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        // TODO: password가 평문으로 들어가 있기 때문에 이렇게 넣어줌
        User user = new User(administrator.getUsername(), administrator.getPassword(), authorities);

        return user;
    }
}
