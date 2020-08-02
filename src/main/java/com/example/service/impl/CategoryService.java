package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Category;
import com.example.repositories.CategoryRepository;
import com.example.service.ICategoryService;
@Service

public class CategoryService implements ICategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);		
	}

}
