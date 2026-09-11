package com.eren.repository;

import com.eren.entity.Auth;

public interface AuthRepository extends MyGenericRepo<Auth,Long> {
    Boolean existsByUserNameAndPassword(String userName, String password);
}
