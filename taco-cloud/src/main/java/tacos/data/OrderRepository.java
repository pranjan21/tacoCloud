package tacos.data;

import org.springframework.stereotype.Repository;

import tacos.domains.Order;

@Repository
public interface OrderRepository {

	public Order save(Order order);
}
