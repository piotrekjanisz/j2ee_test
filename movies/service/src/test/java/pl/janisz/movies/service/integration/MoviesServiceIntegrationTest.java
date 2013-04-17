package pl.janisz.movies.service.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.janisz.movies.service.MoviesServiceImpl;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext-service.xml", "classpath:/applicationContext-dao.xml"})
public class MoviesServiceIntegrationTest {
	@Autowired private MoviesServiceImpl moviesService;
	
	@Test public void serviceIsWired() {
		assertThat(moviesService, notNullValue());
	}
	
	@Test public void returnsSomeValues() {
		assertThat(moviesService.getAllMovies(), is(not(empty())));
	}
}
