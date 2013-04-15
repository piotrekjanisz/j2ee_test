package pl.janisz.movies.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesController {

	@RequestMapping(value="/movies")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("movies");
		
		modelAndView.addObject("param", "value");
		
		return modelAndView;
	}
}
