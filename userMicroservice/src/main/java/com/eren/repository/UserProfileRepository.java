package com.eren.repository;

import com.eren.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository <UserProfile,String>{

}
