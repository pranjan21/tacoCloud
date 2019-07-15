package tacos.data;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import tacos.domains.Order;
import tacos.domains.Taco;

@Repository
public class JdbcOrderRepository implements OrderRepository {


	private SimpleJdbcInsert orderInserter;
	private SimpleJdbcInsert orderTacoInserter;
	private ObjectMapper objectMapper;
	
	public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
		this.orderInserter = new SimpleJdbcInsert(jdbcTemplate);
		this.orderInserter.setTableName("Taco_Order");
		this.orderInserter.usingGeneratedKeyColumns("id");
		
		this.orderTacoInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Taco_Order_Tacos");
		
		this.objectMapper = new ObjectMapper();
	}
	
	@Override
	public Order save(Order order) {
		
		order.setPlacedAt(new Date());
		
		long orderId = saveOrderInfo(order);
		order.setId(orderId);
		
		List<Taco> tacos = order.getTacos();
		
		for (Taco taco : tacos) {
			saveTacoToOrder(taco, orderId);
		}
		
		return order;
	}
	
	private long saveOrderInfo(Order order) {
		@SuppressWarnings("unchecked")
		Map<String, Object>values = objectMapper.convertValue(order, Map.class);
		long orderId = this.orderInserter.executeAndReturnKey(values).longValue();
		return orderId;
	}
	
	private void saveTacoToOrder(Taco taco, long orderId) {
		Map<String, Object> values = objectMapper.convertValue(taco, Map.class);
		values.put("tacoOrder", orderId);
		values.put("taco", taco.getId());
		this.orderTacoInserter.execute(values);
	}

}
