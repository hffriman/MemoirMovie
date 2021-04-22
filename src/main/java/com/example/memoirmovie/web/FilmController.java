package com.example.memoirmovie.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.memoirmovie.domain.GenreRepository;
import com.example.memoirmovie.domain.Film;
import com.example.memoirmovie.domain.FilmRepository;
	
	// Creating a FilmController
	// that defines what will happen
	// in those endpoints of the application
	// that have something to do with the
	// Film and Genre classes
	@Controller
	public class FilmController {
	
	
		// Creating objects for both 
		// FilmRepository and GenreRepository
		
		@Autowired
		private FilmRepository frepo;
		
		@Autowired
		private GenreRepository grepo;
		
		
		// Creating a function login,
		// which returns the login.html
		// page when the user is in
		// in the endpoint "/login",
		
		@RequestMapping(value= "/login")
		public String login() {
			
			return "login";
			
		}
		
		// Creating a function filmlist, 
		// which uses the FilmRepository to 
		// find information from all of the existing Film objects,
		// puts it into the model called "films" and then returns
		// the "filmlist.html" page where the model can be viewed 
		// ---> This function starts when the user
		// ---- is in either the default endpoint ("/")
		// -----or in the endpoint "/filmlist"
		@GetMapping({"/", "/filmlist"})
		public String filmlist(Model model) {
			
			model.addAttribute("films", frepo.findAll());
			
			return "filmlist";
		}
		
		
		// Creating a function findFilmRest, which is shown
		// to the user whenever they they write a value of
		// the Film class' id attribute after the "/film" endpoint
		// ------> URL takes the number as a parameter representing id attribute
		// ------> and uses FilmRepository's function to return the Film object 
		// ------> with that same value as its id attribute
		
		@RequestMapping(value="/film/{id}", method=RequestMethod.GET)
		public @ResponseBody Optional<Film> findFilmRest(@PathVariable("id") long id) {
			
			return frepo.findById(id);
			
		}
		
		
		// Creating a function addFilm, which
		// creates a new Film object, stores it
		// into the model called "film" and also
		// uses GenreRepository to find every Genre
		// object and store the results into the
		// model called "genres"
		// --> Finally the page "addfilm.html" is returned
		// --> The function executes whenever the user is
		// --> in the endpoint "/add"
		@RequestMapping(value = "/add")
		public String addFilm(Model model) {
			
			model.addAttribute("film", new Film());
			model.addAttribute("genres", grepo.findAll());
			
			return "addfilm";
		}
		
		// Creating a function saveFilm, which uses FilmRepository
		// to save a current film object and brings back
		// the "filmlist.html" page after the save process is done
		// ----> This function happens right before the application
		// ----> in "addfilm" is submitted, which is why endpoint "/save"
		// ----> is not accessible on its own
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveFilm(Film film) {
			
			frepo.save(film);
			
			return "redirect:filmlist";
			
		}
		
		
		// Creating a function editFilm, which uses the FilmRepository
		// to find the Film object based on the number that is sent
		// as the parameter representing Film object's id attribute
		// and stores its result to the model named "film",
		// while ALSO using GenreRepository to find every existing
		// Genre object and store them into the model "genres"
		// ---> After that, the page "editfilm.html" is returned
		// ---> The function is executed whenever the user has 
		// ---> submitted the value of id after the endpoint "/edit",
		// ---> but the endpoint can also be accessed by pressing
		// ---> a button or a link
			@RequestMapping(value = "/edit/{id}")
			public String editFilm(@PathVariable("id") Long id, Model model) {
	
				model.addAttribute("film", frepo.findById(id));
				model.addAttribute("genres", grepo.findAll());
	
				return "editfilm";
				
			}
			
		// Creating a function deleteFilm, which uses FilmRepository
		// to delete a Film object based on the submitted id attribute,
		// sends the results to a model "film" and finally returns 
		// the page "filmlist.html"
		// ---> Like in editFilm function, the Film object's id attribute
		// ---> can be given by either putting the value after the endpoint "/delete"
		// ---> or by executing the function through a button or a link
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteFilm(@PathVariable("id") long id, Model model) {
			
			
			frepo.deleteById(id);
			
			model.addAttribute("film", model);
			
			return "redirect:../filmlist";
			
		}
	}
