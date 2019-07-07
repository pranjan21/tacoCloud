package tacos;

import static com.sun.tools.sjavac.Log.info;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.Order;

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
	public String processOrder(Order order) {
//		info("Order Submitted" + order );
		return "redirect:/";
	}
	
}
