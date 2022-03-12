package com.irlan.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irlan.dsmovie.dto.MovieDTO;
import com.irlan.dsmovie.dto.ScoreDTO;
import com.irlan.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	/*
	 * @RequestBody Faz o sistema entender que o corpo do objeto a ser adicionado
	 */
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		
		return movieDTO;
	}

}
