package pl.janisz.movies.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.janisz.movies.dao.dataModel.Movie;

@Repository
public class MovieDAO extends GenericHibernateDAO<Movie> {
	
}
