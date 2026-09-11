package com.eren.service;

import com.eren.document.UserProfile;
import com.eren.dto.resquest.CreatUserRequestDto;
import com.eren.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;

    public void createUser(CreatUserRequestDto dto) {
        repository.save(UserProfile.builder()
                  .authId(dto.getAuthId())
                  .userName(dto.getUsername())
                  .email(dto.getEmail())
                .build());
    }
    public List<UserProfile> GetAll() {
       return repository.findAll();
    }
}
