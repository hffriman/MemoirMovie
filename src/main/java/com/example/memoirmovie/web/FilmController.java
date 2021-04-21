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

@Controller
public class FilmController {


	
	@Autowired
	private FilmRepository frepo;
	
	@Autowired
	private GenreRepository grepo;
	
	
	@RequestMapping(value= "/login")
	public String login() {
		
		return "login";
		
	}
	
	
	@GetMapping({"/", "/filmlist"})
	public String filmlist(Model model) {
		
		model.addAttribute("films", frepo.findAll());
		
		return "filmlist";
	}
	
	@RequestMapping(value="/film/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Film> findFilmRest(@PathVariable("id") long id) {
		
		return frepo.findById(id);
		
	}
	
	@RequestMapping(value = "/add")
	public String addFilm(Model model) {
		
		model.addAttribute("film", new Film());
		model.addAttribute("genres", grepo.findAll());
		
		return "addfilm";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFilm(Film film) {
		
		frepo.save(film);
		
		return "redirect:filmlist";
		
	}
	
		@RequestMapping(value = "/edit/{id}")
		public String editFilm(@PathVariable("id") Long id, Model model) {

			model.addAttribute("film", frepo.findById(id));
			model.addAttribute("genres", grepo.findAll());

			return "editfilm";
			
		}
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteFilm(@PathVariable("id") long id, Model model) {
		
		
		frepo.deleteById(id);
		
		model.addAttribute("film", model);
		
		return "redirect:../filmlist";
		
	}
}
