package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.ICategoryService;

@Controller
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/admin/list")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listCategory",categoryService.getAllCategory());
		return "listMovie";
	}
}
