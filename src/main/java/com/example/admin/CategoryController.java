package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entities.Category;
import com.example.service.ICategoryService;

@Controller
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/admin/list")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listCategory",categoryService.getAllCategory());
		return "category/listMovie";
	}
	@GetMapping("/admin/edit")
	public String showNewCategory(Model model)
	{
		Category category = new Category();
		model.addAttribute("category",category);
		return "category/editMovie";
	}
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category)
	{
		categoryService.saveCategory(category);
		return "redirect:/admin/list";
	}
	@GetMapping("/updateCategory/{id}")
	public String updateCategory(@PathVariable(value="id") long id,Model model )
	{
		Category category =categoryService.getCategoryById(id);
		model.addAttribute("category",category);
		return "category/updateCategory";
	}
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable(value="id") long id )
	{
		categoryService.deleteCategoryById(id);
		return "redirect:/admin/list";
	}
}
