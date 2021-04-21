package com.example.memoirmovie.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long genreid;
	private String genrename;


	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="genre")
	private List<Film> films;
	
	
	public Genre() {}
	
	public Genre(String genrename) {
		super();
		this.genrename = genrename;
	}

	public long getGenreid() {
		return genreid;
	}

	public void setGenreid(long genreid) {
		this.genreid = genreid;
	}

	public String getGenrename() {
		return genrename;
	}

	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setMovies(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", genrename=" + genrename + ", films=" + films + "]";
	}

}