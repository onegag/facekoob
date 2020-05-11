package com.tamkovich.facekoob.service;


import com.tamkovich.facekoob.entity.Status;
import com.tamkovich.facekoob.entity.UserEntity;
import com.tamkovich.facekoob.repository.UserRepository;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import static com.tamkovich.facekoob.entity.Status.*;


@Service
public class StatusSchedulerService {

    private static final String CRON = "*/10 * * * * *";

    @Autowired
    UserRepository repository;

    @Autowired
    StatusChanger changer;

    @Scheduled(cron = CRON)
    public void statusOnlineCheck() {
        LocalDateTime currentTimestamp = LocalDateTime.now(ZoneOffset.UTC);
        List<UserEntity> users = repository.findAllByStatus(Status.ONLINE);


        List<UserEntity> expiredStatusList =
                users.stream()
                        .filter((x) -> x.getLastStatusUpdate()
                                .isBefore(currentTimestamp.minusMinutes(x.getStatus().getStatusValue())))
                        .collect(Collectors.toList());

        expiredStatusList.iterator().forEachRemaining(x->changer.change(x,AWAY));
    }
}
