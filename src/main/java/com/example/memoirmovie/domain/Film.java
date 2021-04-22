package com.example.memoirmovie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// Creating Film class that is being
// produced into a database table
// with @Entity annotation
	@Entity
	public class Film {

	
		// Creating an attribute called id,
		// which is also made the key attribute
		// to the Film database table with the
		// help of @Id and @GeneratedValue annotations
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	
		// Other attributes of the Film class include:
		// writtenby ---> The name of the user who reviews the film
		// title -------> The name of the title the user is reviewing
		// releasedate -> The official release date of the film
		// length ------> The length of the film in minutes
		// director ----> Names of one or multiple directors of the film
		// cast --------> Names of the main actors of the film
		// production company --> The name of the film's production company
		private String writtenby;
		private String title;
		private String releasedate;
		private long length;
		private String director;
		private String cast;
		private String productioncompany;
		
		// The following attributes are about the review itself:
		// review1 ----> The first part of the review
		// review2 ----> The second part of the review
		// review3 ----> The third part of the review
		// NB: THERE ARE THREE REVIEW ATTRIBUTES BECAUSE
		// ONE TEXT AREA CAN HAVE MAXIMUM OF 255 CHARACTERS,
		// WHICH MIGHT BE TOO SHORT FOR THE WRITER
		//------------> THE CONTENTS OF THREE TEXT AREAS ARE COMBINED
		//------------> INTO ONE COMPLETE TEXT IN THE FILMLIST.HTML
		private String review1;
		private String review2;
		private String review3;
		
		// The last attributes are about the grade of the film
		// mygrade ----> The grade that the user gives to the film
		// maxgrade ---> The maximum grade that the user can give
		// NB: mygrade and maxgrade ARE SHOWN IN THE FILMLIST.HTML
		// IN THE FORM OF"mygrade/maxgrade"
		// ------------> EVERY FILM GETS "1 TO 5 POINTS OUT OF 5"
		private long mygrade;
		private long maxgrade = 5;
		
		
		// Creating a relation between
		// database tables FILM and GENRE
		// by using the following annotations:
		// --@ManyToOne: defines that there can
		// ------------- be only ONE GENRE
		// ------------- to LIMITLESS AMOUNT OF FILMS
		// --@JoinColumn: creates the exact relation
		// ------------- between FILM and GENRE by
		// ------------- creating a foreign key from
		// ------------- the primary key of GENRE table
		// --@JsonManagedReference: uses the Json format
		// ------------------------ to keep track of the ongoing
		// ------------------------ relation of FILM and GENRE
		@ManyToOne
		@JoinColumn(name = "genreid")
		@JsonManagedReference
		// Creating the object based on Genre class
		private Genre genre;
		
		
		
		
		// Creating two constructors for Film class:
		// - One without parameteres
		// - One with all the parameters (except id)
		
		public Film() {}
		
		public Film(String writtenby, String title, String releasedate, long length, String director, String cast, String productioncompany, String review1, String review2, String review3, long mygrade, long maxgrade, Genre genre) {
			
			super();
			this.writtenby = writtenby;
			this.title = title;
			this.releasedate = releasedate;
			this.length = length;
			this.director = director;
			this.cast = cast;
			this.productioncompany = productioncompany;
			this.review1 = review1;
			this.review2 = review2;
			this.review3 = review3;
			this.mygrade = mygrade;
			this.maxgrade = maxgrade;
			this.genre = genre;
		}
	
		
		
		// Creating all the Get and Set functions
		// for all the attributes of the Film class
		
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
		
		public String getWrittenby() {
			return writtenby;
		}
		
		public void setWrittenby(String writtenby) {
			this.writtenby = writtenby;
		}
		
		public String getTitle() {
			return title;
		}
	
		public void setTitle(String title) {
			this.title = title;
		}
	
		public String getReleasedate() {
			return releasedate;
		}
	
		public void setReleasedate(String releasedate) {
			this.releasedate = releasedate;
		}
	
		public long getLength() {
			return length;
		}
	
		public void setLength(long length) {
			this.length = length;
		}
	
		public String getDirector() {
			return director;
		}
	
		public void setDirector(String director) {
			this.director = director;
		}
	
		public String getCast() {
			return cast;
		}
	
		public void setCast(String cast) {
			this.cast = cast;
		}
	
		public String getProductioncompany() {
			return productioncompany;
		}
	
		public void setProductioncompany(String productioncompany) {
			this.productioncompany = productioncompany;
		}
	
		public String getReview1() {
			return review1;
		}
	
		public void setReview1(String review1) {
			this.review1 = review1;
		}
	
		public String getReview2() {
			return review2;
		}
	
		public void setReview2(String review2) {
			this.review2 = review2;
		}
	
		public String getReview3() {
			return review3;
		}
	
		public void setReview3(String review3) {
			this.review3 = review3;
		}
	
		public long getMygrade() {
			return mygrade;
		}
	
		public void setMygrade(long mygrade) {
			this.mygrade = mygrade;
		}
	
		public long getMaxgrade() {
			return maxgrade;
		}
	
		public void setMaxgrade(long maxgrade) {
			this.maxgrade = maxgrade;
		}
	
		public Genre getGenre() {
			return genre;
		}
	
		public void setGenre(Genre genre) {
			this.genre = genre;
		}
	
		
		// Creating a toString function to every attribute of the Film class
		@Override
		public String toString() {
			return "Film [id=" + id + ", writtenby=" + writtenby+ ", title=" + title + ", releasedate=" + releasedate
					+ ", length=" + length + ", director=" + director + ", cast=" + cast + ", productioncompany="
					+ productioncompany + ", review1=" + review1 + ", review2=" + review2 + ", review3=" + review3
					+ ", mygrade=" + mygrade + ", maxgrade=" + maxgrade + ", genre=" + genre + "]";
		}
	
	}
