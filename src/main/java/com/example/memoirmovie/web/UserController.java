package com.example.memoirmovie.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.memoirmovie.domain.ResetPasswordForm;
import com.example.memoirmovie.domain.SignupForm;
import com.example.memoirmovie.domain.User;
import com.example.memoirmovie.domain.UserRepository;


	// Creating a UserController
	// that defines what will happen
	// in those endpoints of the application
	// that have something to do with the
	// User class
	@Controller
	public class UserController {
		
		// Creating an object of UserRepository
		@Autowired
		private UserRepository urepo;
		
		// Creating a function addUser, which
		// creates a new SignupForm object
		// based on SingupForm class,
		// adds its value to model named "signupform"
		// and then returns "signup.html" page
		// ---> The function happens whenever the user
		// ---> is in the endpoint "signup"
		@RequestMapping(value = "signup")
		public String addUser(Model model) {
			model.addAttribute("signupform", new SignupForm());
			return "signup";
		}
		
		// Creating a function forgotPassword, which
		// creates a ResetPasswordForm based on 
		// ResetPasswordForm class, adds its value
		// to a model named "passwordresetform" and
		// then returns "resetpassword.html" page
		// ---> The function happens whenever the user
		// ---> is in the endpoint "resetpassword"
		@RequestMapping(value = "resetpassword")
		public String forgotPassword(Model model) {
			model.addAttribute("passwordresetform", new ResetPasswordForm());
			return "resetpassword";
		}
		
		// Creating the function save, which happens at the endpoint "saveuser" 
		// after the application form in "signup.html" has been submitted
		//---> THE FOLLOWING THINGS HAPPEN IN THE FUNCTION:
		//
		//--->  1. If method checks checks if the BindingResult object has received any
		//         errors from the signup.html regarding the attribute regulations set by the
		//         SignupForm class (attributes correct character sizes etc.)
		//--------------> is there are problems, the signup.html is immediately returned
		//--------------> if not, the function continues its execution
		//
		//----> 2. Another if method checks if the two passwords from the SignupForm object are identical to each other
		//--------------> if no, the BindingResult object receives the error message and the signup.html is shown
		//--------------> if yes, the password is received from the signup.html, encrypted by the BCryptpasswordEncoder object
		//                and then set as a new String, waiting to be saved into the new User object
		//
		//----> 3. New User object is created, and the username, security question and security answer from the SignupForm
		//         object are set as the new User object's attributes, and it also has its password attribute set
		//         based on the value of the previously-created String variable that contains the encrypted password
		//---------> NB: the role attribute is created automatically
		//
		//----> 4. The final if method checks if the new User object has an username nobody else has
		//--------------> if there already is NOT unique, the BindingResult shows an error message and returns the signup.html page
		//--------------> if the username IS unique, the User is saved by the UserRepository, and the login.html page is shown
		
		@RequestMapping(value = "saveuser", method = RequestMethod.POST)
		public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
			if (!bindingResult.hasErrors()) {
				if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
					String pwd = signupForm.getPassword();
					BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
					String hashPwd = bc.encode(pwd);
					
					String pwdnew = signupForm.getAnswer();
					String answerPwd = bc.encode(pwdnew);
				
					User newUser = new User();
					newUser.setPasswordHash(hashPwd);
					newUser.setUsername(signupForm.getUsername());
					newUser.setQuestion(signupForm.getQuestion());
					newUser.setAnswer(answerPwd);
					newUser.setRole("USER");
					
					if (urepo.findByUsername(signupForm.getUsername()) == null) {
							urepo.save(newUser);
					} else {
							bindingResult.rejectValue("username", "err.username", "Username is already taken");
							return "signup";
					}
				} else {
					bindingResult.rejectValue("passwordCheck", "err.password", "Passwords do not match");
					return "signup";
				}
			}
			else {
				return "signup";
			}
			return "redirect:/login";
		}
		
	
		
		// THIS FUNCTION DOESN'T WORK, UNFORTUNATELY
		//---> HOWEVER, I WOULD LIKE TO EXPLAIN 
		//---> HOW IT WAS SUPPOSED TO WORK
		//
		// Creating a function savePassword, which executes in the endpoint "savenewpassword"
		// immediately after the application form in resetpassword.html is submitted
		//
		// THE FOLLOWING THINGS HAPPEN IN THE FUNCTION:
		//
		// 1. if method checks if the BindingResult object has received any errors from 
		//    resetpassword.html regarding the attribute regulations set by ResetPasswordForm class
		//-----------> if there are any issues, the resetpassword.html is shown
		//-----------> if everything is okay, the function continues
		//
		// 2. another if method checks if the two passwords given in the ResetPasswordForm object are identical
		//-----------> if not, the BindingResult object receives error messages and shows resetpassword.html
		//-----------> if yes, the password is brought from the ResetPasswordForm object, generated into encrypted form
		//              by BCryptPasswordEncoder object and then stored into a new String variable
		//
		// 3. the third if method checks immediately if the security question and security answer from ResetPasswordForm object
		//    is the same as the security question and security answer from the username written in ResetPasswordForm object
		//------------> if they are NOT, the BindingResult object receives error messages and the resetpassword.html is shown
		//------------> if they ARE, the user object gets its username from the ResetPasswordForm object and its password
		//              attribute is set to be the value from the String variable containing encrypted password
		//
		// 4. the final if method checks if the username surely exists
		//------------> if it does NOT, the BindingObject class receives error messages and the resetpassword.html is shown
		//------------> if it DOES, the user is saved by the UserRepository and the login.html page is shown
		
		@RequestMapping(value = "savenewpassword", method = RequestMethod.POST)
		public String savePassword(@Valid @ModelAttribute("passwordresetform") ResetPasswordForm resetPasswordForm, BindingResult bindingResult) {
			if (!bindingResult.hasErrors()) {
				if (resetPasswordForm.getPassword().equals(resetPasswordForm.getPasswordCheck())) {
					String pwd = resetPasswordForm.getPassword();
					BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
					String hashPwd = bc.encode(pwd);
					
					if (resetPasswordForm.getQuestion().equals(urepo.findByUsername(resetPasswordForm.getUsername()).getQuestion()) 
							&& resetPasswordForm.getAnswer().equals(urepo.findByUsername(resetPasswordForm.getAnswer()).getAnswer())) {
								
								
								User currentUser = urepo.findByUsername(resetPasswordForm.getUsername());
								currentUser.setPasswordHash(hashPwd);
								
							
							if (urepo.findByUsername(resetPasswordForm.getUsername()) != null) {
	
								urepo.save(currentUser);
								
							} else {
								bindingResult.rejectValue("username", "err.username", "Username does not exist");
								return "resetpassword";
							}
					} else {
						bindingResult.rejectValue("question", "err.question", "Check your question");
						bindingResult.rejectValue("answer", "err.answer", "Check your answer");
						return "resetpassword";
					}
				} else {
					bindingResult.rejectValue("passwordCheck", "err.password", "Passwords do not match");
					return "resetpassword";
				}
			}
			else {
				return "resetpassword";
				
			}
			return "redirect:/login";
		}
	}