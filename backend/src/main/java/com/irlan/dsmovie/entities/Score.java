package com.irlan.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
	// tem que instanciar o scorePK pra garantir que é chave primaria
	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;

	public Score() {

	}

	public Score(ScorePK id, Double value) {
		super();
		this.id = id;
		this.value = value;
	}

	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}

	public void setUser(User user) {
		id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
