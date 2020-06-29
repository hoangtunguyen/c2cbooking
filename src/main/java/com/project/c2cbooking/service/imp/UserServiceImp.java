package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.model.UserEntity;
import com.project.c2cbooking.repository.UserRepository;
import com.project.c2cbooking.response.UserResponse;
import com.project.c2cbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserResponse getUser(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserResponse response = new UserResponse();
        response.setUserName(userEntity.getUsername());
        response.setEmail(userEntity.getEmail());
        response.setUserId(userEntity.getId());
        response.setUrlImage(userEntity.getUrlImage());
        return response;
    }
}
