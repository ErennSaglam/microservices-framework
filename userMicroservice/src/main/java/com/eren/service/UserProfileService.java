package com.eren.service;

import com.eren.document.UserProfile;
import com.eren.dto.resquest.CreatUserRequestDto;
import com.eren.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private final CacheManager cacheManager;
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

    @Cacheable("upper-case")
    public String upperName(String name) {
        String result =name.toUpperCase();
        try{
           Thread.sleep(3000L);
        } catch (InterruptedException e) {}
        return result;
    }
    public void clearCach(){
        cacheManager.getCache("upper-case").clear();
    }
}
