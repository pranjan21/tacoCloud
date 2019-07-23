package tacos.Messaging;

import org.springframework.stereotype.Service;
import tacos.domains.Order;

@Service
public interface OrderMessagingService {

    public void sendOrder(Order order);
}
