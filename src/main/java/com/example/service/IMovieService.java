package com.example.service;

import com.example.dto.MovieDTO;

public  interface IMovieService {
	MovieDTO save(MovieDTO movieDTO);
	void delete(long[] ids);
}
