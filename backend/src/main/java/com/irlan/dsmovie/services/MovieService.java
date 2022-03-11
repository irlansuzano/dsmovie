package com.irlan.dsmovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irlan.dsmovie.dto.MovieDTO;
import com.irlan.dsmovie.entities.Movie;
import com.irlan.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	//a persistencia ja instancia para vc com essa declaração
	@Autowired
	private MovieRepository repository ;
	
	/*
	 * Pageable pageable serve pra retornar os produtos em uma 
	 * quantidade especifica, só instanciar dentro da função
	 * e transferir para dentro do findAll do repository
	 * 
	 * transformei de Page<Movie> -> DTO
	 */
	@Transactional(readOnly = true)//apenas leitura (deixa mais rapido)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	/*
	 * findById retorna um objeto optional, o que n eh o ideal
	 * p/ acessar o objeto dentro do optional vc usa o get
	 */
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
