package com.heesoo.nutrient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NutrientController {
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
}
