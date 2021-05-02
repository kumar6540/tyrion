package com.salesforce.MyshoppingCart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesforce.MyshoppingCart.Entity.Category;
import com.salesforce.MyshoppingCart.Entity.Product;
import com.salesforce.MyshoppingCart.Service.ProductService;
import com.salesforce.MyshoppingCart.Service.Service;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private Service service;
	
	
	@GetMapping("/products")
	public String getProductList(Model model) {
		
		List<Product> plist = productService.getProductList();
		
		model.addAttribute("productlist", plist);
		
		return "ProductList";
		
	}
	
	
	@GetMapping("/products/create")
	public String showNewProdctForm(Model model) {
		
		List<Category> listCategories = service.getCategoryList();

	
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories",listCategories);
		
		return "Product_form";
		
	}
	
	@PostMapping("/products/save")	
	public String savaProduct(Product product,HttpServletRequest request) {
		
		
		
			
		
		
		productService.saveproduct(product);
		return "redirect:/products";
		
	}
	
	@GetMapping("/products/update/{id}")
	public String UpdateProduct(@PathVariable("id") Integer id, Model model,HttpServletRequest request) {
		List<Category> listCategories = service.getCategoryList();
		model.addAttribute("listCategories",listCategories);
		
		Product product = productService.getProductById(id);
		
		model.addAttribute("product",product);
		
		
		return "Product_form";
	}
	
	@GetMapping("/products/Delete/{id}")
	public String DeleteProduct(@PathVariable("id") Integer id, Model model) {
	
		productService.deleteById(id);
		
		return "redirect:/products";
}}
