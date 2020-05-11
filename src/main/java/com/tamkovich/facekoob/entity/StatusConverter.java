package com.tamkovich.facekoob.entity;


import com.tamkovich.facekoob.entity.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;


@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getStatusValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer statusValue) {
        if (statusValue == null) {
            return null;
        }

        return Stream.of(Status.values())
                .filter(c -> c.getStatusValue().equals(statusValue))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

