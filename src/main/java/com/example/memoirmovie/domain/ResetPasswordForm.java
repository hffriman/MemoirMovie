package com.example.memoirmovie.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ResetPasswordForm {

	@NotEmpty
	@Size(min=5, max=30)
	private String username = "";
	
	@NotEmpty
	@Size(min=10, max=50)
	private String question = "";
	
	@NotEmpty
	@Size(min=1, max=50)
	private String answer = "";
	
	@NotEmpty
	@Size(min=7, max=30)
	private String password = "";
	
	@NotEmpty
	@Size(min=7, max=30)
	private String passwordCheck = "";
	
	@NotEmpty
	private String role = "USER";

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

