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
	
	@Before public void setUpDatabase() {
		database = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
	}
	
	@After public void tearDownDatabase() {
		database.shutdown();
	}
	
	@Test public void testDatabaseIsNotEmpty() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
		List<Map<String, Object>> allMovies = jdbcTemplate.queryForList("SELECT * FROM movies");
		assertThat(allMovies, is(not(empty())));
	}
}
