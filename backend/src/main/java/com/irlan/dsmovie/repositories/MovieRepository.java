package com.irlan.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irlan.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	

}
