package tacos.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.domains.Order;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/current")
	public String showCurrentOrder(Model model) {
//		info("Showing current order" );

		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors) {
//		info("Order Submitted" + order );
		
		if (errors.hasErrors()) {
			return "orderForm";
		}
		
		return "redirect:/";
	}
	
}
