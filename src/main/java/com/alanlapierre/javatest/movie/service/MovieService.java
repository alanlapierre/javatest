package com.alanlapierre.javatest.movie.service;

import com.alanlapierre.javatest.movie.data.MovieRepository;
import com.alanlapierre.javatest.movie.model.Genre;
import com.alanlapierre.javatest.movie.model.Movie;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
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
		if((template == null) || (template.getMinutes()!=null && template.getMinutes()<0)){
			throw new IllegalArgumentException("Minutes can not be negative");
		}
		
		Stream<Movie> movieStream = movieRepository.findAll().stream();
			
		if(template.getId()!=null) {
			movieStream =  movieStream.filter(movie -> movie.getId() == template.getId());
		}
		else {
			Predicate<Movie> isName = n -> n.getName().toLowerCase().contains(Optional.ofNullable(template.getName()).orElse("").toLowerCase());
			Predicate<Movie> isMinutes = n -> n.getMinutes() <= Optional.ofNullable(template.getMinutes()).orElse(n.getMinutes());
			Predicate<Movie> isGenre = n -> n.getGenre().toString().contains(Optional.ofNullable(template.getGenre()).orElse(Genre.EMPTY).toString());
			movieStream = movieStream.filter(isName.and(isMinutes).and(isGenre));
		}
		return movieStream.collect(Collectors.toList());
		
		
	}
}
