package com.tamkovich.facekoob.dto;

import com.tamkovich.facekoob.entity.Status;

public class StatusRequest {
    Integer id;
    Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusRequest() {
    }
}
