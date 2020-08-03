package com.example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.dto.CategoryDTO;
import com.example.entities.Category;
@Component
public class CategoryConverter {
	static ModelMapper modelMapper = new ModelMapper();
	public CategoryDTO convertToCatgoryDTO(Category category)
	{
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
	public Category convertToCategoryEntity(CategoryDTO categoryDTO)
	{
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}
}
