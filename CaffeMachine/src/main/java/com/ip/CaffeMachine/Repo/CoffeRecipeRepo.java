package com.ip.CaffeMachine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.CaffeMachine.Models.CoffeRecipeEntity;
import com.ip.CaffeMachine.Models.UserEntity;

@Repository
public interface CoffeRecipeRepo extends JpaRepository<CoffeRecipeEntity, Long> {

}
