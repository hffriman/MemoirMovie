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
	
	private String writtenby;
	private String title;
	private String releasedate;
	private long length;
	private String director;
	private String cast;
	private String productioncompany;
	private String review1;
	private String review2;
	private String review3;
	private long mygrade;
	private long maxgrade = 5;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	@JsonManagedReference
	private Genre genre;
	
	
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

	@Override
	public String toString() {
		return "Film [id=" + id + ", writtenby=" + writtenby+ ", title=" + title + ", releasedate=" + releasedate
				+ ", length=" + length + ", director=" + director + ", cast=" + cast + ", productioncompany="
				+ productioncompany + ", review1=" + review1 + ", review2=" + review2 + ", review3=" + review3
				+ ", mygrade=" + mygrade + ", maxgrade=" + maxgrade + ", genre=" + genre + "]";
	}

}
