package com.aleksis.backend.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/open")
    public String open() {
        return "open";
    }

    @GetMapping("/closed")
    public String close() {
        return "closed";
    }

    @GetMapping("/special")
    public String special() {
        return "special";
    }

    @GetMapping("/basic")
    public String basic() {
        return "basic";
    }
}
