package com.ip.CaffeMachine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.CaffeMachine.Models.RecipeEntity;
import com.ip.CaffeMachine.Models.UserEntity;

@Repository
public interface RecipeRepo extends JpaRepository<RecipeEntity, Long> {

	RecipeEntity findByTitle(String title);
}
