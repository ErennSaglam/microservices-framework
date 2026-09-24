package com.eren.controller;

import com.eren.document.UserProfile;
import com.eren.dto.resquest.CreatUserRequestDto;
import com.eren.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.eren.config.RestApi.*;
import java.util.List;

@RestController
@RequestMapping(USERPROFİLE)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> creatUser(@RequestBody CreatUserRequestDto dto){
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> GetAll(){
        return ResponseEntity.ok(userProfileService.GetAll());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String name) {
       return ResponseEntity.ok(userProfileService.upperName(name));
    }
}
