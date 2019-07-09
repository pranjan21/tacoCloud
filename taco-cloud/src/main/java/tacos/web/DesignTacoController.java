package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.stream.Stream;

import tacos.data.IngredientRepository;
import tacos.domains.Ingredient;
import tacos.domains.Taco;
import tacos.domains.Ingredient.Type;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

	private final IngredientRepository ingredientRepo;
	
	public DesignTacoController(IngredientRepository ingredientRepo, Chicken chicken, TacoMgr tacoManager) {
		this.ingredientRepo = ingredientRepo;
	}
	
//	@ModelAttribute
//	public void addIngredientsToModel(Model model) {
//		List<Ingredient> ingredients = Arrays.asList(
//				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//				new Ingredient("CHED", "Cheddar", Type.CHEESE),
//				new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//				new Ingredient("SLSA", "Salsa", Type.SAUCE),
//				new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//				);
//
//		Type[] types = Ingredient.Type.values();
//		for (Type type : types) {
//			model.addAttribute(type.toString().toLowerCase(),
//					filterByType(ingredients, type));
//		}
//	}

	@ModelAttribute
	public void getIngredients(Model model) {
		
		List<Ingredient> ingredients = (List<Ingredient>) this.ingredientRepo.findAll();
	
		Type[] types = Ingredient.Type.values();
		
		
		for (Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), 
					filterByType(ingredients, type) );
		}
	}

	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("design", new Taco());
		return "design";
	}

	@PostMapping
	public static String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "design";
		}

		return "redirect:/orders/current";
	}


	private List<Ingredient> filterByType(
			List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}

}
