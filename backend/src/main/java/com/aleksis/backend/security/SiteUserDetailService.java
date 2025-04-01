package com.aleksis.backend.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SiteUserDetailService implements UserDetailsService {

    private final SiteUserRepo siteUserRepo;

    public SiteUserDetailService(SiteUserRepo siteUserRepo) {
        this.siteUserRepo = siteUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        SiteUser siteUser = siteUserRepo.findById(username).get();

        return User.withUsername(siteUser.getUsername())
                .password(siteUser.getPassword())
                .build();
    }
}
