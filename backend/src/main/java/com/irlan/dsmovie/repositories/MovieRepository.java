package com.irlan.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irlan.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	/*
	 * Interface apenas para implementar as ações que o
	 *  repositorio da JPA disponibiliza para aplicarmos em 
	 *  outros metodos
	 * 
	 */
	

}
