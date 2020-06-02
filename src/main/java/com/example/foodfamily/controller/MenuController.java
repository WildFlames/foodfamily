package com.example.foodfamily.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.foodfamily.entity.Category;
import com.example.foodfamily.entity.Product;
import com.example.foodfamily.repository.CategoryRepository;
import com.example.foodfamily.service.ProductService;

@Controller
public class MenuController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("menu")
	public String menuShow(HttpSession session, Model model, HttpServletRequest request) {

		List<Category> categories = categoryRepository.findAll();
		Page<Product> page = null;
		String locale = (String) session.getAttribute("lang");
		Long id = (Long) session.getAttribute("id");
		Integer filterId = (Integer) session.getAttribute("filterId");

		if (locale == null) {
			session.setAttribute("lang", "ua");
			locale = (String) session.getAttribute("lang");
		}
		if (filterId == null) {
			session.setAttribute("filterId", 1);
			filterId = (Integer) session.getAttribute("filterId");
		}
		if (id == null) {
			session.setAttribute("id", 0L);
			id = (Long) session.getAttribute("id");
		}	
		if (id != 0) {
			Category type = categoryRepository.findOne(id);
			model.addAttribute("type", type.getType());
		}

		page = productService.filter(locale, filterId, id);

		for (Product product : page) {
			request.setAttribute("product", productService.findProductById(product.getId()));
		}

		model.addAttribute("categories", categories);
		request.setAttribute("page", page);
		model.addAttribute("url", "/menu");
		return "menu";
	}

	@PostMapping("menu")
	public void menuGetFilter(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "filterId", required = false) Integer filterId, Model model, HttpSession session,
			HttpServletRequest request) {
		if (id != null) {
			session.setAttribute("id", id);
		}
		if (filterId != null) {
			session.setAttribute("filterId", filterId);
		}
		menuShow(session, model, request);
	}
}