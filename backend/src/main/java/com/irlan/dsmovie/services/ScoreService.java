package com.irlan.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irlan.dsmovie.dto.MovieDTO;
import com.irlan.dsmovie.dto.ScoreDTO;
import com.irlan.dsmovie.entities.Movie;
import com.irlan.dsmovie.entities.Score;
import com.irlan.dsmovie.entities.User;
import com.irlan.dsmovie.repositories.MovieRepository;
import com.irlan.dsmovie.repositories.ScoreRepository;
import com.irlan.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	// a persistencia ja instancia para vc com essa declaração
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	/*
	 * busca o usuario por email pega o email e salva, dps retorna uma referencia
	 * saveAndFlush retorna sempre o usuario "fresco", logo apos a atualização
	 */
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		//pega o filme ID		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		// salva o novo score completo
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()){
			sum = sum + s.getValue();
		}
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
