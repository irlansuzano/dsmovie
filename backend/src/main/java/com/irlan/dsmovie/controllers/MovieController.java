package com.irlan.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irlan.dsmovie.dto.MovieDTO;
import com.irlan.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	/*
	 * Assim como o service depende do repository o controller depende do service
	 * ele tem que ser instanciado aqui tbm
	 */
	@Autowired
	private MovieService service;

	/*
	 * Get do HTTP do spring
	 */
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}
	/*
	 * eh a forma para identificar e passar o parametro id
	 */
	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

}
