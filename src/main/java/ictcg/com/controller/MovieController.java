package ictcg.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ictcg.com.repository.IMovieRepository;

public class MovieController {
	
	@Autowired
    private IMovieRepository movieRepository;
	
	@RequestMapping("/movies")
	public String goToMovies( Model modelMovie) {
		
//		 IReactiveDataDriverContextVariable datadriven =
//				 	                new ReactiveDataDriverContextVariable(movieRepository.findAll(), 1);
//		
		// modelMovie.addAttribute("movies", datadriven ) ;
		
		modelMovie.addAttribute("Movies",movieRepository.findAll());
		
		return "TableMovie";
	}

}
