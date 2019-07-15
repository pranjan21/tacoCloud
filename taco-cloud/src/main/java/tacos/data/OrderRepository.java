package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.domains.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}