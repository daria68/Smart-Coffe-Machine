package com.ip.CaffeMachine.Repo;

import com.ip.CaffeMachine.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
