package ictcg.com.repository;

import ictcg.com.model.Movie;
import reactor.core.publisher.Flux;

public interface IMovieRepository {
	
	Flux<Movie> findAll();

}
