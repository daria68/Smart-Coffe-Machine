package com.ip.CaffeMachine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.CaffeMachine.Models.DrinkEntity;

@Repository
public interface DrinkRepo extends JpaRepository<DrinkEntity, Long> {

}
