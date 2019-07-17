package tacos.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.data.OrderRepository;
import tacos.domains.Order;

import java.util.Optional;

@RequestMapping(path = "/order")
@CrossOrigin("*")
public class OrderRestController {

    private OrderRepository orderRepo;

    public OrderRestController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public Iterable<Order> getOrder() {
        return this.orderRepo.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOrderById(@PathVariable  Long orderId) {
        Optional<Order> optionalOrder = this.orderRepo.findById(orderId);

        if (optionalOrder.isPresent()) {
            return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
