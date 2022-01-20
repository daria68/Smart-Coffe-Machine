package com.ip.CaffeMachine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.CaffeMachine.Models.PresonalizedDrinkEntity;

@Repository
public interface PersonalizedDrinkRepo extends JpaRepository<PresonalizedDrinkEntity, Long> {

}
