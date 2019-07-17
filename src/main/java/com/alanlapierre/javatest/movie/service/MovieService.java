package com.alanlapierre.javatest.movie.service;

import com.alanlapierre.javatest.movie.data.MovieRepository;
import com.alanlapierre.javatest.movie.model.Genre;
import com.alanlapierre.javatest.movie.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieService {

	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Collection<Movie> findMoviesByGenre(Genre genre) {

		return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre)
				.collect(Collectors.toList());
	}

	public Collection<Movie> findMoviesByLength(int length) {

		return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length)
				.collect(Collectors.toList());
	}
	
	public Collection<Movie> findByName(String name) {
		return movieRepository.findAll().stream()
				.filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	public Collection<Movie> findMoviesByTemplate(Movie template) throws IllegalArgumentException {
		
		if(template!=null) {
			
			Stream<Movie> movieStream = movieRepository.findAll().stream();
			
			if(template.getId()!=null) {
				movieStream =  movieStream.filter(movie -> movie.getId() == template.getId());
			}
			else {
				if(template.getName() != null) {
					movieStream = movieStream.filter(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase()));
				}
				
				if(template.getMinutes()!= null) {
					
					if(template.getMinutes() > 0) {
						movieStream = movieStream.filter(movie -> movie.getMinutes() <= template.getMinutes());
					} else {
						throw new IllegalArgumentException("Minutes can not be negative");
					}
				}

				if(template.getGenre()!= null) {
					movieStream = movieStream.filter(movie -> movie.getGenre() == template.getGenre());
				}
			}
			
			return movieStream.collect(Collectors.toList());
		}
		else {
			throw new IllegalArgumentException("Param is null");
		}
		
	}
}
