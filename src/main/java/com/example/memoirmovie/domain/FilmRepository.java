package com.example.memoirmovie.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FilmRepository extends CrudRepository<Film, Long> {

	
	List<Film> findByTitle(@Param("title") String title);
	
	List<Film> findByDirector(@Param("director") String director);

	
}
