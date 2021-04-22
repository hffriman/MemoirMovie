package com.example.memoirmovie.domain;
	
import java.util.List;
	
import org.springframework.data.repository.CrudRepository;
	
	
	// Creating a GenreRepository interface that uses the abilities
	// of CrudRepository to Create, Read, Update and Delete (CRUD)
	// the Genre objects
	public interface GenreRepository extends CrudRepository<Genre, Long> {
	
		// Creating a method findByGenrename, which
		// creates a list of Genre objects that share
		// the same value in their genrename attribute
		// as the parameter of this method
		List<Genre>findByGenrename(String genrename);
		
	}
