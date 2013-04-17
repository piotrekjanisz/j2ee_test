package pl.janisz.movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.janisz.movies.service.MoviesServiceImpl;

@Controller
public class MoviesController {
	
	@Autowired MoviesServiceImpl moviesService;
	
	@RequestMapping(value="/movies")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("movies");
		modelAndView.addObject("movies", moviesService.getAllMovies());
		return modelAndView;
	}
}
