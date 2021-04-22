package com.example.memoirmovie.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

	// Creating a class that defines
	// the attributes needed in the 
	// form of resetpassword.html
	// AND UserController
	// ----> This file was needed in the
	// ----> function that resets the
	// ----> users password, but
	// ----> I could not succeed
	// ----> in making it work
	public class ResetPasswordForm {
	
	// The form of resetting the password
	// needed these attributes:
		
		// NB: THE ANNOTATION @NotEmpty means
		// that the attributes can not be null
		
		// NB: THE ANNOTATION @Size means
		// that the value of an attribute
		// must be between the minimum and
		// maximum number of characters
		
		// Username
		@NotEmpty
		@Size(min=5, max=30)
		private String username = "";
		
		// Security question that
		// the user has created in
		// the registration process
		@NotEmpty
		@Size(min=10, max=50)
		private String question = "";
		
		// Security answer that was
		// also created in the
		// registration process
		@NotEmpty
		@Size(min=1, max=50)
		private String answer = "";
		
		// Password
		@NotEmpty
		@Size(min=7, max=30)
		private String password = "";
		
		// Another password section,
		// which is used to ensure
		// that the user has written
		// the same password twice
		@NotEmpty
		@Size(min=7, max=30)
		private String passwordCheck = "";
		
		// Role that was granted to
		// the user in the registration
		// ----> NB: this one may not
		// ----> be that necessary in the
		// ----> password reset process
		// ----> but is kept just in case
		@NotEmpty
		private String role = "USER";
		
		
		// Creating the Set and Get methods
		// for all the attributes of the class
		
		public String getUsername() {
			return username;
		}
	
		public void setUsername(String username) {
			this.username = username;
		}
	
		public String getQuestion() {
			return question;
		}
	
		public void setQuestion(String question) {
			this.question = question;
		}
	
		public String getAnswer() {
			return answer;
		}
	
		public void setAnswer(String answer) {
			this.answer = answer;
		}
	
		public String getPassword() {
			return password;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
	
		public String getPasswordCheck() {
			return passwordCheck;
		}
	
		public void setPasswordCheck(String passwordCheck) {
			this.passwordCheck = passwordCheck;
		}
	
		public String getRole() {
			return role;
		}
	
		public void setRole(String role) {
			this.role = role;
		}
	
		
	}
	
