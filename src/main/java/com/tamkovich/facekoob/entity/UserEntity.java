package com.tamkovich.facekoob.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Mail is mandatory")
    private String mail;
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    private Status status;

    @JsonIgnore
    private LocalDateTime lastStatusUpdate=LocalDateTime.now(ZoneOffset.UTC);




    public UserEntity() {
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public LocalDateTime getLastStatusUpdate() {
        return lastStatusUpdate;
    }

    public void setLastStatusUpdate(LocalDateTime lastStatusUpdate) {
        this.lastStatusUpdate = lastStatusUpdate;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}
