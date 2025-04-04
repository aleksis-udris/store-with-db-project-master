package com.aleksis.backend.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRepo extends JpaRepository<SiteUser, String> {
}
