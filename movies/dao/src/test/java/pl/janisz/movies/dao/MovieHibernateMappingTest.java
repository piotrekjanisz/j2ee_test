package pl.janisz.movies.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import pl.janisz.movies.dao.dataModel.Movie;

public class MovieHibernateMappingTest {
	private EmbeddedDatabase database;
	private EntityManagerFactory entityManagerFactory;
	
	@Before public void setUpDatabase() {
		database = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		entityManagerFactory = Persistence.createEntityManagerFactory("pl.janisz.movies.jpa");
	}
	
	@After public void tearDownDatabase() {
		database.shutdown();
		entityManagerFactory.close();
	}
	
	@Test public void canGetListOfAllMovies() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        List<Movie> result = entityManager.createQuery( "from Movie", Movie.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        assertThat(result, is(not(empty())));
	}
	
	@Test public void canSaveAMovie() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Movie movie = new Movie();
		movie.setName("Dark Knight");
		entityManager.persist(movie);
		
        List<Movie> result = entityManager.createQuery( "from Movie", Movie.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
	}
}
