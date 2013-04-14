package pl.janisz.movies.dao.repositories;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.janisz.movies.dao.dataModel.Movie;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-testDao.xml")
@Transactional
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository movies;
	
	@Test public void moviesRepositoryIsWired() { 
		assertThat(movies, notNullValue());
	}

	
	@Test public void canGetAllMovies() {
		assertThat(movies.findAll(), is(not(emptyIterable())));
	}
	
	@Test public void canPersistMovie() {
		final String MOVIE_NAME = "Name of the Rose";
		Movie newMovie = new Movie(MOVIE_NAME);
		movies.save(newMovie);
		assertThat(movies.findByName(MOVIE_NAME), notNullValue());
	}
}
