package com.tamkovich.facekoob.service;

import com.tamkovich.facekoob.entity.Status;
import com.tamkovich.facekoob.entity.UserEntity;
import com.tamkovich.facekoob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class StatusChanger {

    @Autowired
    UserRepository repository;



    public UserEntity change(UserEntity user, Status newStatus){
        user.setStatus(newStatus);
        user.setLastStatusUpdate(LocalDateTime.now(ZoneOffset.UTC));
        repository.save(user);
        return user;

    }



}
