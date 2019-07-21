package tacos.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.data.TacoRepository;
import tacos.domains.Taco;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignRestTacoController {

    private TacoRepository tacoRepo;

    @Autowired
    public DesignRestTacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping
    public String sayHello() {
        return "design";
    }

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
//        PageRequest pageRequest = PageRequest.of(0,12, Sort.by("createdAt").descending());
//        return this.tacoRepo.findAll(pageRequest).getContent();
        return this.tacoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoWithId(@PathVariable("id") Long id) {
        Optional<Taco> taco = this.tacoRepo.findById(id);
        if (taco.isPresent()) {
            return ResponseEntity.ok(taco.get());
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco processOrder(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

//    @PatchMapping(path="/{orderId}", consumes = "application/json")
//    public Order patchOrder(@PathVariable("orderId") Long orderId, @RequestBody Order patch) {
//        Order order = orderRepo.findById(orderId).get();
//        if(patch.getName() != null) {
//            order.setName(patch.getName());
//        }
//
//        return orderRepo.save(order);
//    }
//
//    @DeleteMapping("/{orderId}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public void deleteOrder(@PathVariable("orderId") Long orderId) {
//        try {
//            orderRepo.deleteById(orderId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

