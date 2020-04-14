package com.cg.movieapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movieapp.dao.MovieAppDao;
import com.cg.movieapp.entities.Movie;
import com.cg.movieapp.exceptions.MovieNotFoundException;
@Service
public class MovieAppServiceImpl implements MovieAppService {
	@Autowired
	MovieAppDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Movie addMovie(Movie movie) {
		Movie robj =dao.save(movie);
		return robj;
	}

	@Override
	public List<Movie> findMovieByGenre(String genre) throws MovieNotFoundException {
		
		List<Movie> movieList =dao.findByGenre(genre);
		if(movieList.isEmpty())
		{
			throw new MovieNotFoundException("No MovieFound");
		}
		else
		{
			return movieList;
		}
	}

	@Override
	public List<Movie> findMovies() {
		return (List<Movie>) dao.findAll();

	}
	
}
