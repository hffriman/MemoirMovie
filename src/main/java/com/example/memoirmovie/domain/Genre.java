package com.example.memoirmovie.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Creating a class Genre
// that is also made into
// the database table
// by @Entity annotation
	@Entity
	public class Genre {

		// Creating an attribute called genreid,
		// which is also made into primary key 
		// of the database table GENRE
		// by using @Id and @GeneratedValue annotations
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long genreid;
		
		// Another attribute is:
		// genrename --> name of the Genre
		private String genrename;
	
		
		// Creating a relation between FILM and GENRE tables and classes
		// by using the following:
		// --@JsonIgnore: makes the table relation undisturbed
		// --@OneToMany: gives Genre class an ability to store
		// ------------- MULTIPLE FILMS in ONLY one GENRE
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy="genre")
		// With the help of the annotations above, a List object
		// is created as an attribute to store multiple Film objects
		private List<Film> films;
		
		
		// Creating constructors of Genre class with and without parameters
		// --- NB: genreid is not used as a parameter
		public Genre() {}
		
		
		// Creating Get and Set methods for all 
		// the attributes of the Genre class
		// ---> includes the Film list
		
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
	
		// Creating a toString method for all the attributes of the Genre class
		
		@Override
		public String toString() {
			return "Genre [genreid=" + genreid + ", genrename=" + genrename + ", films=" + films + "]";
		}
	
	}