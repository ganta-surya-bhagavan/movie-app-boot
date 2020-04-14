package com.cg.movieapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movieapp.entities.Movie;
import com.cg.movieapp.services.MovieAppService;
import com.cg.movieapp.services.MovieAppServiceImpl;

@RestController
public class MovieAppController {
	@Autowired
	MovieAppService service;
	  @CrossOrigin("http://localhost:4200")
	@PostMapping(value="/addmovie" , produces="application/json",  headers = "Accept=application/json")	
	public @ResponseBody Movie  addMovie( @RequestBody  Movie movie)
		{
		System.out.println(movie);
		return service.addMovie(movie);
		
		}
	  @CrossOrigin("http://localhost:4200")
	@GetMapping(value="/{genre}",produces = "application/json",    headers = "Accept=application/json")
	public @ResponseBody List<Movie>  findMovieByGenre( @PathVariable("genre") String genre)
	{
	
	return service.findMovieByGenre(genre);
	
	}
	
	@GetMapping(value="/movies",produces = "application/json",headers = "Accept=application/json")
	public @ResponseBody List<Movie>  findMovies( )
	{
	
	return service.findMovies();
	
	}

}
