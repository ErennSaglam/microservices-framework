package com.eren.repository;

import com.eren.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutRepository extends JpaRepository<Auth,Long> {
}
