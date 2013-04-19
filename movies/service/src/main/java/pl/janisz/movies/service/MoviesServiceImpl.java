package pl.janisz.movies.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.janisz.movies.dao.dataModel.Movie;
import pl.janisz.movies.dao.repositories.MovieRepository;

@Component
@Transactional
public class MoviesServiceImpl {
	@Autowired
	@Getter @Setter
	private MovieRepository movies;
	
	
	public List<Movie> getAllMovies() {
		return movies.findAll();
	}


	public Movie getMovie(Long id) {
		return movies.findOne(id);
	}
	
	public Movie addMovie(Movie movie) {
		return movies.save(movie);
	}
}
