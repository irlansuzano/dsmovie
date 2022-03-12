package com.irlan.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irlan.dsmovie.entities.Score;
import com.irlan.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
	

}
