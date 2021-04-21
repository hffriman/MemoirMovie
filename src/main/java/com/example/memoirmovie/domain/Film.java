package com.example.memoirmovie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Film {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String releasedate;
	private long length;
	private String director;
	private String cast;
	private String productioncompany;
	private String review;
	private long mygrade;
	private long maxgrade = 5;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	@JsonManagedReference
	private Genre genre;
	
	
	public Film() {}
	
	public Film(String title, String releasedate, long length, String director, String cast, String productioncompany, String review, long mygrade, long maxgrade, Genre genre) {
		
		super();
		this.title = title;
		this.releasedate = releasedate;
		this.length = length;
		this.director = director;
		this.cast = cast;
		this.productioncompany = productioncompany;
		this.review = review;
		this.mygrade = mygrade;
		this.maxgrade = maxgrade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public void setLenght(long length) {
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
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", releasedate=" + releasedate + ", length=" + length
				+ ", director=" + director + ", cast=" + cast + ", productioncompany=" + productioncompany + ", review="
				+ review + ", mygrade=" + mygrade + ", genre=" + genre + "]";
	}
}
