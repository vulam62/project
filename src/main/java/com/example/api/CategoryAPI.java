package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ICategoryService;
@CrossOrigin
@RestController
public class CategoryAPI {
	@Autowired
	private ICategoryService categoryService;
	
	
	
}
