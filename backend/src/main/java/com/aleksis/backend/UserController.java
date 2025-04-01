package com.aleksis.backend;

import com.aleksis.backend.security.SiteUser;
import com.aleksis.backend.security.SiteUserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173/", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final PasswordEncoder passwordEncoder;

    private final SiteUserRepo siteUserRepo;

    public UserController(PasswordEncoder passwordEncoder, SiteUserRepo siteUserRepo) {
        this.passwordEncoder = passwordEncoder;
        this.siteUserRepo = siteUserRepo;
    }

    @SuppressWarnings("SimplifyOptionalCallChains")
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody SiteUser user) {
        Optional<SiteUser> optionalUser = siteUserRepo.findById(user.getUsername());
        if (!optionalUser.isPresent()) {
            siteUserRepo.save(new SiteUser(user.getUsername(), passwordEncoder.encode(user.getPassword())));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
}
