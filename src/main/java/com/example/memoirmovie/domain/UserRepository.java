package com.example.memoirmovie.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	User findByQuestion(String question);
	User findByAnswer(String answer);

}
