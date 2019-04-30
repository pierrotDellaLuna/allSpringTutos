package ictcg.com.repository;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.CipherInputStream;

import ictcg.com.model.Movie;
import reactor.core.publisher.Flux;

public class MovieRepository implements IMovieRepository{
	
	public static List<Movie> cinema = new ArrayList<>() ;
	
	static {
		cinema.add(new Movie( "Red_October" , 86));
		cinema.add(new Movie( "Inception" , 856));
		cinema.add(new Movie( "Justice League" , 31));
		cinema.add(new Movie( "Ghostbusters" , 44));
		cinema.add(new Movie( "Indiana_Jones" , 56));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Flux<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getCinema() {
		return cinema;
	}

	public void setCinema(List<Movie> cinema) {
		this.cinema = cinema;
	}
	
	

}
