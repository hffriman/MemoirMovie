package com.example.memoirmovie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.memoirmovie.domain.FilmRepository;
import com.example.memoirmovie.domain.GenreRepository;
import com.example.memoirmovie.domain.UserRepository;
import com.example.memoirmovie.web.FilmController;
import com.example.memoirmovie.web.UserController;
import com.example.memoirmovie.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemoirmovieApplicationTests {

	
	@Autowired
	private FilmController filmcontroller;
	
	@Autowired
	private UserController usercontroller;
	
	@Autowired
	private UserDetailServiceImpl userdetailserviceimpl;
	
	@Autowired
	private FilmRepository filmrepository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@Autowired
	private UserRepository userrepository;
	
	// SIMPLE TEST:
	// CHECK THAT THE IMPORTANT CONTROLLERS AND SERVICES EXIST
	@Test
	void contextLoads() throws Exception {
		
		assertThat(filmcontroller).isNotNull();
		
		assertThat(usercontroller).isNotNull();
		
		assertThat(userdetailserviceimpl).isNotNull();
		
	}
	
	// SIMPLE TEST 2:
	// CHECK THAT ALL THE REPOSITORIES EXIST
	
	@Test
	void anotherContextLoads() throws Exception {
		
		assertThat(filmrepository).isNotNull();
		assertThat(genrerepository).isNotNull();
		assertThat(userrepository).isNotNull();
		
	}

}
