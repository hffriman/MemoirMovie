package com.example.memoirmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.memoirmovie.web.UserDetailServiceImpl;

	// Creating a WebSecutiryConfig class that uses the capabilities
	// of WebSecurityConfigurerAdapter class and security annotations
	// to define the access and limitations of the application users
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		// Creating a UserDetailServiceImpl object userDetailsService
		// that is used to check if the user has the both 
		// the right status (signed in/out) and role (admin/user) 
		@Autowired	
		private UserDetailServiceImpl userDetailsService;
	
		
		// Creating the exact configuration function that
		// defines the requirements of user status and roles
		// to different parts of the application
		@Override
		protected void configure(HttpSecurity http) throws Exception {
		
		// The configuration is defined as follow:
		//    1. All users, even those not logged in,
		//       are able to access the style pages (css)
		//       AND registration and password reset pages
		//		 of the application
		//
		//    2. Other pages are not available 
		//       for the users not logged in
		//
		//    3. The website of the login page is defined
		//       to be in the endpoint "/login"
		//       ---> NB: The html file of Login page
		//       ---> is returned in FilmController class
		//
		//	  4. An endpoint "/filmlist" is set as the page
		//       where the user is brought immediately
		//       after having logged into the application
		//		 ---> NB: the html file for 
		//       ---> set in the FilmController class
		//
		//	  5. Logout function is allowed for any user
		http
			.authorizeRequests().antMatchers("/css/**").permitAll()
			.and()
			.authorizeRequests().antMatchers("/signup", "/saveuser", "/resetpassword", "/savenewspassword").permitAll()
			.and()
			.authorizeRequests().anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/filmlist", true)
			.permitAll()
			.and()
		.logout()
				.permitAll();
	
}

		// Creating a function that uses 
		// AuthenticationManagerBuilder object
		// and the passwordEncoder attribute 
		// of userDetailsService class in order
		// to secure the credentials
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	
		}

}
