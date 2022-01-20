package com.ip.CaffeMachine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.CaffeMachine.Models.ProgramEntity;

@Repository
public interface ProgramRepo extends JpaRepository<ProgramEntity, Long>  {

}
