package com.example.memoirmovie.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	// Creating a User class that is also
	// being created into the database table
	// by @Entity annotation
	// ----> NB: @Table annotation is used to give
	// ----> a database table a different name,
 	// ----> which is done due to the usage of name "User"
	// ----> being forbidden in the PostGresSQL database
	@Entity
	@Table(name="usertable")
	public class User {
		
		
		// Two things are happening below:
		// 		1. Creation of an attribute id, which is also being
		// 		generated into a primary key with annotations
		// 		like @Id and @GeneratedValue
		//		2. Creation of database table columns based on the
		//         attributions of User class with @Column annotation
		//		NB: The @Column annotation has strict rules in order
		// 			to keep the User tables secure from modification
		
		// The attributes of User class are:
		//  Username --> the name the user has in the application 
		//  Security question --> the question that the user sets in the registration in
		//----------------------> order to have a chance of resetting the passwords later
		//  Security answer ----> the answer to the security question that the user also sets in the 
		//----------------------> registration in order to have a chance of resetting the password later
		//  PasswordHash -------> the secured password which the user needs in order to log in to the application.
		//  Role ---------------> the role that is automatically assigned to the user in the registration
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", nullable = false, updatable = false)
		private long id;
		
		@Column(name = "username", nullable = false, unique = true)
		private String username;
		
		@Column(name = "question", nullable = false)
		private String question;
		
		@Column(name = "answer", nullable = false)
		private String answer;
		
		@Column(name = "password", nullable = false)
		private String passwordHash;
		
		@Column(name = "role", nullable = false)
		private String role;
		
		
		
		// Creating two constructors for User class, with and without parameters (excluding id)
		
		public User() {}
		
		public User(String username, String question, String answer, String passwordHash, String role) {
			super();
			this.username = username;
			this.question = question;
			this.answer = answer;
			this.passwordHash = passwordHash;
			this.role = role;
		}
	
		
		// Creating Get and Set methods for all the attributes in the User class
		
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
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
	
		public String getPasswordHash() {
			return passwordHash;
		}
	
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
	
		public String getRole() {
			return role;
		}
	
		public void setRole(String role) {
			this.role = role;
		}
	
		
		// Creating a toString function for all the attributes in the User class
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", question=" + question + ", answer=" + answer
					+ ", passwordHash=" + passwordHash + ", role=" + role + "]";
		}	
	}
