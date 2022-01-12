package com.example.memoirmovie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.memoirmovie.domain.Genre;
import com.example.memoirmovie.domain.GenreRepository;
import com.example.memoirmovie.domain.UserRepository;
import com.example.memoirmovie.domain.Film;
import com.example.memoirmovie.domain.FilmRepository;

@SpringBootApplication
public class MemoirmovieApplication {


	// Creating a Logger object that can be used to put necessary
	// information into the console when the program is using database.
	private static Logger log = LoggerFactory.getLogger(MemoirmovieApplication.class);
	
	// The main function which is needed for the program to function at all
	public static void main(String[] args) {
		SpringApplication.run(MemoirmovieApplication.class, args);
	}

	
	// Creating a CommandLineRunner function which is 
	// executed every time the program starts functioning
	@Bean
	public CommandLineRunner demo(FilmRepository frepo, GenreRepository grepo, UserRepository urepo) {
		
		
		// The function returns arguments and converts them to the database
		return (args) -> {
			 
			// Using GenreRepository
			// to delete all Genre objects in order to
			// prevent them to multiply every time the
			// application is rebooted
			grepo.deleteAll();
			
			urepo.deleteAll();
			
			// Using the Logger object to send
			// a message to the console in order to
			// notify the developer when the
			// GenreRepository starts to
			// create Genre objects
			log.info("Creating genres");
			
			// GenreRepository uses its CRUD (create, read, update and delete)
			// capabilities to create new Genre objects with different names
			// ---> NB: the first one is empty, because we want the program
			// ---> to have one "undefined" Genre
			grepo.save(new Genre(" "));
			grepo.save(new Genre("Drama"));
			grepo.save(new Genre("Science Fiction"));
			grepo.save(new Genre("Fantasy"));
			grepo.save(new Genre("Comedy"));
			grepo.save(new Genre("Action"));
			grepo.save(new Genre("Thriller"));
			grepo.save(new Genre("Avant Garde"));
			
			// Using the Logger object again to send
			// a message to the console in order
			// to notify the developer
			log.info("Fetch all films");
			
			// Creating a for loop that uses FilmRepository's 
			// CRUD (create, read, update and delete) capabilities
			// and Loggers message functions to send information
			// of each of the existing Film object into 
			// the console in the form of String
			//----> NB: in this case, there are no Film objects
			//----> existing, but they could be created the same way
			//----> as the Genre objects if wanted
			for (Film film : frepo.findAll()) {
			log.info(film.toString());
			
		}	
		};
		
}
}