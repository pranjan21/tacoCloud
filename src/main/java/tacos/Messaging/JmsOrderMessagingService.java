package tacos.Messaging;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import tacos.domains.Order;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {

    private JmsTemplate jms;
    private Destination orderQueue;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate, Destination orderQueue) {
        this.jms = jmsTemplate;
        this.orderQueue = orderQueue;
    }

    @Override
    public void sendOrder(Order order) {
        jms.convertAndSend(JmsOrderRecievingService.destination, order, message -> {
            message.setStringProperty("X_ORDER_SOURCE", "web");
            return message;
        });
    }
}
