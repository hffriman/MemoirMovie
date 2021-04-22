package com.example.memoirmovie.domain;

import org.springframework.data.repository.CrudRepository;

//Creating a UserRepository interface that uses the abilities
// of CrudRepository interface to Create, Read, Update and Delete (CRUD)
// the User objects based on the User class
	
public interface UserRepository extends CrudRepository<User, Long> {

	// Creating three functions that:
	// 1. Shows the User object that has the same 
	// 	  value in their username attribute
	//    as the value in the parameter
	// 2. Shows the User object that has the same
	// 	  value in their question attribute
	//    as the value in the parameter
	// 3. Shows the User object that has the same
	// 	  value in their answer attribute
	//    as the value in the parameter
	User findByUsername(String username);
	User findByQuestion(String question);
	User findByAnswer(String answer);

}
