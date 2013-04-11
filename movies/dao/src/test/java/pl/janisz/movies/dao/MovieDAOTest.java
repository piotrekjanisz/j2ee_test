package pl.janisz.movies.dao;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.janisz.movies.dao.dataModel.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-testDao.xml")
@Transactional
public class MovieDAOTest {

	@Autowired
	private MovieDAO dao;
	
	@Before public void setUp() {
	}
	
	@After public void tearDown() {
	}
	
	@Test public void daoIsWired() {
		assertThat(dao, notNullValue());
	}
	
	@Test public void canGetAllMovies() {
		dao.saveOrUpdate(new Movie("aaaa"));
		assertThat(dao.getAll(), is(not(empty())));
	}
}
