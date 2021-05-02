package com.salesforce.MyshoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesforce.MyshoppingCart.Entity.Category;
import com.salesforce.MyshoppingCart.Service.Service;

@Controller
public class CategoryController {

	@Autowired
	private Service service;
	
	@GetMapping("/catagories")
	public String getListCategory(Model model) {
		
		List<Category> list = service.getCategoryList();
		
		model.addAttribute("categoriesList",list);
		
		return "CategoryList";
	}
	
	@GetMapping("/categories/create")
	public String showCategoryForm(Model model) {
		
		model.addAttribute("category", new Category());
		
		return "Category_form";
		
	}
	
	@PostMapping("/categories/save")
	public String saveCategory(Category category) {
		
		service.save(category);
		return"redirect:/catagories";
	}
	
}
