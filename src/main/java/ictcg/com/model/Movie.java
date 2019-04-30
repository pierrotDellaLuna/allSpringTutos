package ictcg.com.model;

import lombok.Data;

@Data
public class Movie {
	
	public Integer score ;
	public String naam ;
	
	
	public Movie(Integer score, String naam) {
		super();
		this.score = score;
		this.naam = naam;
	}
	
	public Movie( String naam , Integer score) {
		super();
		this.score = score;
		this.naam = naam;
	}
	
	
	
	

}
