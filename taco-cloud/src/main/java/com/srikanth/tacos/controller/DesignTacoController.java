package com.srikanth.tacos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srikanth.tacos.Ingredient;
import com.srikanth.tacos.Ingredient.Type;
import com.srikanth.tacos.Taco;
//import com.sun.org.slf4j.internal.Logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO","Flour Tortilla",Type.WRAP),
				new Ingredient("COTO","Corn Tortilla",Type.WRAP),
				new Ingredient("GRBF","Ground Beef",Type.PROTEIN),
				new Ingredient("CARN","Carnitas",Type.PROTEIN),
				new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES),
				new Ingredient("LETC","Lettuce",Type.VEGGIES),
				new Ingredient("CHED","Cheddar",Type.CHEESE),
				new Ingredient("JACK","Monterrey Jack",Type.CHEESE),
				new Ingredient("SLSA","Salsa",Type.SAUCE),
				new Ingredient("SRCR","Sour Cream",Type.SAUCE)
				);
		Type[] types = Ingredient.Type.values();
		for(Type eachType:types) {
			model.addAttribute(eachType.toString().toLowerCase(), filterByType(ingredients,eachType));
		}
		model.addAttribute("design", new Taco());
		
		return "design";
	}
	
	@PostMapping
	public String ProcessDesign(@Valid Taco design,Errors errors) {
		if(errors.hasErrors()) {
			//if there is any errors we will return the same page
			return "design";
		}
		// later take care of save 
		// lets focus on logging the data
		//log.info("processing: "+taco);
		System.out.println("processing: "+design);
		
		return "redirect:orders/current";
		
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type eachType) {
		// TODO Auto-generated method stub
		
		return ingredients.stream().filter(x->x.getType().equals(eachType))
				.collect(Collectors.toList());
	}
	
}
