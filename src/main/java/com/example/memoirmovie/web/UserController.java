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


@Controller
public class UserController {
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value = "resetpassword")
	public String forgotPassword(Model model) {
		model.addAttribute("passwordresetform", new ResetPasswordForm());
		return "resetpassword";
	}
	
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