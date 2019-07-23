package tacos.Messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import tacos.domains.Order;

@Component
public class JmsOrderRecievingService implements OrderRecievingService {

    static String destination = "tacocloud.order.queue";

    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderRecievingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @Override
    public Order recieveOrder() {
        return (Order) jmsTemplate.receiveAndConvert(
                destination
        );
    }
}
