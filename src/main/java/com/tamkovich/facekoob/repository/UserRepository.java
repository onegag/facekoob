package com.tamkovich.facekoob.repository;

import com.tamkovich.facekoob.entity.Status;
import com.tamkovich.facekoob.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    List<UserEntity> findAllByStatus(Status status);

}
