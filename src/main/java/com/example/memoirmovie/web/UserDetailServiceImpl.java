package com.example.memoirmovie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.memoirmovie.domain.User;
import com.example.memoirmovie.domain.UserRepository;

// Creating a UserDetailServiceImpl class that uses the abilities of
// UserDetailsService interface maintain a database service of User accounts
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	// Creating an object based on UserRepository interface
	private final UserRepository repository;
	
	// Defining UserDetailServiceImpl class' function, for which
	// the abilities of UserRepository interface are needed
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	// Creating a function loadUserByUsername, which
	// adds the attributes of User class into the UserDetails object
	// through the security methods of spring security, in order to
	// make the registration of unique user accounts possible
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		
		return user;
	}
	
}
