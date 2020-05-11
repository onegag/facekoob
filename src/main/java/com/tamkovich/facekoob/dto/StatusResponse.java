package com.tamkovich.facekoob.dto;

import com.tamkovich.facekoob.entity.Status;

public class StatusResponse {
    Integer id;
    Status previousStatus;
    Status currentStatus;

    public StatusResponse(Integer id, Status previousStatus, Status currentStatus) {
        this.id = id;
        this.previousStatus = previousStatus;
        this.currentStatus = currentStatus;
    }

    public Integer getId() {
        return id;
    }

    public Status getPreviousStatus() {
        return previousStatus;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }
}
