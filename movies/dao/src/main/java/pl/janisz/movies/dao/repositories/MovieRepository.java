package pl.janisz.movies.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.janisz.movies.dao.dataModel.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	Movie findByName(String name);
}
