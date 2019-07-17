package com.alanlapierre.javatest.movie.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.alanlapierre.javatest.movie.data.MovieRepository;
import static org.junit.Assert.*;

import com.alanlapierre.javatest.movie.model.Genre;
import com.alanlapierre.javatest.movie.model.Movie;
import java.util.List;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION),
                        new Movie(8, "Superman Returns", 154, Genre.ACTION)    
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)) );
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)) );
    }
    
    @Test
    public void return_movies_by_name() {
    	Collection<Movie> movies = movieService.findByName("super");
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(4,8)) );
        	
    }
    
    @Test
    public void return_movies_by_template_where_id_is_not_null() {
    	Movie template = new Movie(1, null, null, null);
    	Collection<Movie> movies = movieService.findMoviesByTemplate(template);
    	assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1)) );
    }

    @Test(expected=IllegalArgumentException.class)
    public void throws_exception_in_movies_by_template_when_argument_is_null() {
    	Movie template = null;
    	movieService.findMoviesByTemplate(template);
    }

    @Test(expected=IllegalArgumentException.class)
    public void throws_exception_in_movies_by_template_when_minutes_is_smaller_than_0() {
    	Movie template = new Movie(null, null, -1, null);
    	movieService.findMoviesByTemplate(template);
    }
    
    
    @Test
    public void return_movies_by_template_where_genre_is_not_null() {
    	Movie template = new Movie(null, null, null, Genre.ACTION);
    	Collection<Movie> movies = movieService.findMoviesByTemplate(template);
    	assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1,7,8)) );
    }

    @Test
    public void return_movies_by_template_where_genre_and_minutes_are_not_null() {
    	Movie template = new Movie(null, null, 152, Genre.ACTION);
    	Collection<Movie> movies = movieService.findMoviesByTemplate(template);
    	assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1,7)) );
    }
 
    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}
