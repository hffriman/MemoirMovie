package com.example.memoirmovie.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


	// Creating a FilmRepository interface that uses the abilities
	// of CrudRepository interface to Create, Read, Update and Delete (CRUD)
	// the Film objects based on Film class
	@RepositoryRestResource
	public interface FilmRepository extends CrudRepository<Film, Long> {
	
		// Creating a couple methods for making 
		// the search of the Film much easier:
		//  1. findByTitle, which gets the value representing the film title
		//  --- and creates a List of Film objects that share the title
		//  2. findByDirector, which gets the value representing the
		// ---- name of the film's director and creates a List of Film objects
		// ---- that have the same value in their director attributes
		
		List<Film> findByTitle(@Param("title") String title);
		
		List<Film> findByDirector(@Param("director") String director);
	
		
	}
