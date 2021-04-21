package com.example.memoirmovie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.memoirmovie.domain.Genre;
import com.example.memoirmovie.domain.GenreRepository;
import com.example.memoirmovie.domain.Film;
import com.example.memoirmovie.domain.FilmRepository;

@SpringBootApplication
public class MemoirmovieApplication {


	
	private static Logger log = LoggerFactory.getLogger(MemoirmovieApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MemoirmovieApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(FilmRepository frepo, GenreRepository grepo) {
		
		return (args) -> {
			
			grepo.deleteAll();
			
			log.info("Saving screenings");
			
			grepo.save(new Genre(" "));
			grepo.save(new Genre("Drama"));
			grepo.save(new Genre("Science Fiction"));
			grepo.save(new Genre("Fantasy"));
			grepo.save(new Genre("Comedy"));
			grepo.save(new Genre("Action"));
			grepo.save(new Genre("Thriller"));
			grepo.save(new Genre("Avant Garde"));
			
			log.info("Fetch all screenings");
			
			for (Film film : frepo.findAll()) {
			log.info(film.toString());
			
		}	
		};
		
}
}