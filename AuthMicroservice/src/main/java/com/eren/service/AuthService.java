package com.eren.service;

import com.eren.dto.CreatUserRequestDto;
import com.eren.dto.request.LoginResponseDto;
import com.eren.dto.request.RegisterRequestDto;
import com.eren.entity.Auth;
import com.eren.manager.UserProfileManager;
import com.eren.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;


    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
        userProfileManager.creatUser(CreatUserRequestDto.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .username(auth.getUserName())

                .build());
        return auth;
    }
    public Boolean login(LoginResponseDto dto) {
            return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }

}
