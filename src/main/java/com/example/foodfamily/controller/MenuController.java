package com.example.foodfamily.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.foodfamily.entity.Category;
import com.example.foodfamily.entity.Product;
import com.example.foodfamily.repository.CategoryRepository;
import com.example.foodfamily.repository.ProductRepository;

@Controller
public class MenuController {

	@Autowired
	private ProductRepository menuItemRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/menu")
	public String menuShow(HttpSession session, Model model) {
		String locale = (String) session.getAttribute("lang");
		Long id = (Long) session.getAttribute("id");

		if (locale == null) {
			session.setAttribute("lang", "ua");
			locale = (String) session.getAttribute("lang");
		}

		if (id == null) {
			List<Product> menuItems = menuItemRepository.findAllByLocale(locale);
			model.addAttribute("menuItems", menuItems);
		} else {
			List<Product> menuItems = menuItemRepository.findAllByCategoryIdAndLocale(id, locale);
			model.addAttribute("menuItems", menuItems);
		}

		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("id", id);
		return "menu";
	}

	@PostMapping("/menu")
	public void menuFilter(@RequestParam(name = "id", required = false) Long id, Model model, HttpSession session) {

		session.setAttribute("id", id);
		menuShow(session, model);
	}
}
