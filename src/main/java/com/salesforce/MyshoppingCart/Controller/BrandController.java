package com.salesforce.MyshoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesforce.MyshoppingCart.Entity.Brand;
import com.salesforce.MyshoppingCart.Entity.Category;
import com.salesforce.MyshoppingCart.Service.BrandService;
import com.salesforce.MyshoppingCart.Service.Service;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	@Autowired
	private Service Catservice;

	@GetMapping("/Brands/create")
	public String showCreateBrandForm(Model model) {

		List<Category> catlist= Catservice.getCategoryList();
		model.addAttribute("catlist",catlist);

		model.addAttribute("brand", new Brand());
		return "Brand_form";

	}

	@PostMapping("/Brands/save")
	public String saveBrand(Brand brand) {

		brandService.save(brand);
		return "redirect:/Brands";

	}

	@GetMapping("/Brands")
	public String getBrandList(Model model) {
		List<Brand> blist= brandService.getBrandList();

		model.addAttribute("brandlist", blist);

		return "Brandlist";
	}

	@GetMapping("/Brands/update/{id}")
	public String deleteBrand(@PathVariable("id") Integer id,Model model) {
		List<Category> catlist= Catservice.getCategoryList();
		model.addAttribute("catlist",catlist);

		Brand brand = brandService.getBrandById(id);
		model.addAttribute("brand", brand);
		return "Brand_form";
	}


	@GetMapping("/Brands/Delete/{id}")
	public String DeleteBrand(@PathVariable("id") Integer id, Model model) {

		brandService.deleteById(id);

		return "redirect:/Brands";
	}
}