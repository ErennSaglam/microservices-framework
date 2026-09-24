package com.eren.controller;

import com.eren.dto.request.LoginResponseDto;
import com.eren.dto.request.RegisterRequestDto;
import com.eren.entity.Auth;
import com.eren.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.eren.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVİCE)
public class AuthController {

    private final AuthService service;

    @PostMapping(REGİSTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto) {
        if (!dto.getPassword().equals(dto.getRepassword())) {
            throw new RuntimeException("Şifreler uyuşmuyor.");
        }
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(LOGİN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
