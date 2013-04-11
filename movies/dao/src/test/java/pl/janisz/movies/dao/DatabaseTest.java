package pl.janisz.movies.dao;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class DatabaseTest {

	private EmbeddedDatabase database;
	private JdbcTemplate jdbcTemplate;
	
	@Before public void setUpDatabase() {
		database = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		jdbcTemplate = new JdbcTemplate(database);
	}
	
	@After public void tearDownDatabase() {
		database.shutdown();
	}
	
	@Test public void testDatabaseIsNotEmpty() {
		List<Map<String, Object>> allMovies = jdbcTemplate.queryForList("SELECT * FROM movies");
		assertThat(allMovies, is(not(empty())));
	}
	
	@Test public void moviesTableHasIdColumn() {
		assertThat(firstRowFromMoviesTable(), hasKey("ID"));
	}
	
	@Test public void moviesTableHasVersionColumn() {
		assertThat(firstRowFromMoviesTable(), hasKey("VERSION"));
	}
	
	@Test public void moviesTableHasNameColumn() {
		assertThat(firstRowFromMoviesTable(), hasKey("NAME"));
	}
	
	private Map<String, Object> firstRowFromMoviesTable() {
		List<Map<String, Object>> allMovies = jdbcTemplate.queryForList("SELECT * FROM movies");
		return allMovies.get(0);
	}
}
