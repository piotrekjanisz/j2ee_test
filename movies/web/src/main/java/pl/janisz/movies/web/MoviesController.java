package pl.janisz.movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.janisz.movies.dao.dataModel.Movie;
import pl.janisz.movies.service.MoviesServiceImpl;

@Controller
public class MoviesController {
	
	@Autowired MoviesServiceImpl moviesService;
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("movies", moviesService.getAllMovies());
		return "movies/index";
	}
	
	@RequestMapping(value="/movies/{movieId}")
	public String show(@PathVariable String movieId, Model model) {
		model.addAttribute("movie", moviesService.getMovie(Long.parseLong(movieId)));
		return "movies/show";
	}
	
	@RequestMapping(value="/movies/new")
	public String newMovie() {
		return "movies/new";
	}
	
	@RequestMapping(value="/movies", method=RequestMethod.POST)
	public String create(@ModelAttribute("movie") Movie movie, Model model) {
		moviesService.addMovie(movie);
		return index(model);
	}
}
