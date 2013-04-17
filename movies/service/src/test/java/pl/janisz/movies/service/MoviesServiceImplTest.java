package pl.janisz.movies.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import pl.janisz.movies.dao.dataModel.Movie;
import pl.janisz.movies.dao.repositories.MovieRepository;

public class MoviesServiceImplTest {
	
	private MoviesServiceImpl moviesService;
	
	@Before public void setUp() {
		moviesService = new MoviesServiceImpl();
	}
	
	@Test public void allMoviesIsNotNull() {
		moviesService.setMovies(mockedMovieRepository());
		assertThat(moviesService.getAllMovies(), is(notNullValue()));
	}
	
	@Test public void allMoviesIsNotEmptyIfRepositoryIsNotEmpty() {
		moviesService.setMovies(mockedMovieRepository());
		assertThat(moviesService.getAllMovies(), is(not(empty())));
	}
	
	@Test public void allMoviesReturnsAllMoviesFromTheRepository() {
		moviesService.setMovies(mockedMovieRepository());
		assertThat(moviesService.getAllMovies(), hasSize(3));
	}
	
	private MovieRepository mockedMovieRepository() {		
		LinkedList<Movie> movieList = new LinkedList<Movie>(Arrays.asList(
				new Movie("test1"),
				new Movie("test2"),
				new Movie("test3")
				));
		MovieRepository movieRepository = mock(MovieRepository.class);
		when(movieRepository.findAll()).thenReturn(movieList);
		return movieRepository;
	}
}
