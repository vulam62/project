package com.example.service.impl;

import java.util.List;
import java.util.Optional;

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
	@Override
	public Category getCategoryById(long id) {
		Optional<Category> optional =categoryRepository.findById(id);
		Category category =null;
		if(optional.isPresent())
		{
			category=optional.get();
		}
		else
		{
			throw new RuntimeException("Category not found");
		}
		return category;
	}
	@Override
	public void deleteCategoryById(long id) {
		categoryRepository.deleteById(id);
	}
	
	
}
