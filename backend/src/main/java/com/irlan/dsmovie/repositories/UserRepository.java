package com.irlan.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irlan.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	/*
	 * O JPA disponibiliza para nós um jeito de realizar a busca 
	 * por um campo especifico que ja tem em banco só de escrever 
	 * da forma acima, passando no final o nome do campo no final
	 * do metodo e como variavel
	 */

}
