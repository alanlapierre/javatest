package com.alanlapierre.javatest.movie.data;

import java.util.Collection;

import com.alanlapierre.javatest.movie.model.Movie;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
