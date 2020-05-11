package com.tamkovich.facekoob.entity;

import com.fasterxml.jackson.annotation.JsonFormat;



@JsonFormat(shape = JsonFormat.Shape.STRING )
public enum Status {
    ONLINE(5), AWAY(30), OFFLINE(1000), NONE(Integer.MAX_VALUE);

    private Integer statusValue;


    Status(Integer statusValue) {
        this.statusValue = statusValue;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

}
