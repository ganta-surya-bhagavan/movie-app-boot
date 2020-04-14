package com.cg.movieapp.services;

import java.util.List;

import com.cg.movieapp.entities.Movie;
import com.cg.movieapp.exceptions.MovieNotFoundException;

public interface MovieAppService {
	Movie addMovie(Movie movie);
	List<Movie> findMovieByGenre(String genre) throws MovieNotFoundException;
	List<Movie> findMovies();
}
