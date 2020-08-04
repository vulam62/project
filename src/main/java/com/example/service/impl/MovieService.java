package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.converter.MovieConverter;
import com.example.dto.MovieDTO;
import com.example.entities.Category;
import com.example.entities.Movie;
import com.example.repositories.CategoryRepository;
import com.example.repositories.MovieRepository;
import com.example.service.IMovieService;
@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired 
	private MovieConverter movieConverter;
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public MovieDTO save(MovieDTO movieDTO) {
		Movie movie = new Movie();
		
		if (movieDTO.getId() != null) {
			Movie oldMovieEntity = movieRepository.findOneById(movieDTO.getId());
			movie = movieConverter.toEntity(movieDTO, oldMovieEntity);
		} else {
			movie = movieConverter.convertToMovieEntity(movieDTO);
		}
		Category categoryEntity = categoryRepository.findOneByCode(movieDTO.getCategoryCode());
		movie.setCategory(categoryEntity);
		movie = movieRepository.save(movie);
		return movieConverter.convertToMovieDTO(movie);
	
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			movieRepository.deleteById(item);
		}

	}
}
