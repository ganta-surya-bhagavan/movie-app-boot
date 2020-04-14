package com.cg.movieapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.movieapp.entities.Movie;
@Repository
public interface MovieAppDao extends CrudRepository<Movie,String> {
	List<Movie> findByGenre(String genre);

}
