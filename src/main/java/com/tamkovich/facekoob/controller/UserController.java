package com.tamkovich.facekoob.controller;


import com.tamkovich.facekoob.dto.StatusRequest;
import com.tamkovich.facekoob.dto.StatusResponse;
import com.tamkovich.facekoob.entity.Status;
import com.tamkovich.facekoob.entity.UserEntity;
import com.tamkovich.facekoob.exception.UserNotFoundException;
import com.tamkovich.facekoob.repository.UserRepository;
import com.tamkovich.facekoob.service.StatusChanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/facekoob")
public class UserController {

    @Autowired
    UserRepository repository;
    @Autowired
    StatusChanger statusChanger;

    @GetMapping
    ResponseEntity<Collection<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(repository.findAll());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer createNewUser (@RequestBody @Valid UserEntity newUserEntity) {
        return repository.save(newUserEntity).getId();

    }


    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity searchUser (@PathVariable( "id") Integer id ) throws Exception {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }


    @PutMapping ( value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatusResponse setNewStatus (@RequestBody StatusRequest statusRequest) throws Exception {
        UserEntity user =  repository.findById(statusRequest.getId()).orElseThrow(UserNotFoundException::new);
        Status previousStatus = user.getStatus();
        statusChanger.change(user, statusRequest.getStatus());
        return new StatusResponse(user.getId(), previousStatus, user.getStatus());

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
