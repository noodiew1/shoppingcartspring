package shoppingcart.message;
import java.io.Serializable;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;

import org.springframework.stereotype.Service;

import shoppingcart.cartobj.CartObject;
import shoppingcart.cartobj.CartObjectRepository;




@Service
public class MessageReceiverCartObject {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	CartObjectRepository cartRepo;
	@JmsListener(destination = "CART_QUEUE.ACTIVE_QUEUE")
	public void receiveQueue(ActiveMQObjectMessage obj) {
		
		Serializable s;
		try {
			s = obj.getObject();
			if (s instanceof CartObject)
			{
				
				CartObject ca = (CartObject)s;
				System.out.println("Message Received: "+ca.toString());
				CartObject ca2 = cartRepo.save(ca);
				
				if (ca2==null) {
					this.jmsMessagingTemplate.convertAndSend("CART_QUEUE.REJOIN_QUEUE", ca);
					System.out.println("Object Pushed into REJOIN_QUEUE");
				}
				else {
					System.out.println("RepoObject: "+ca2.toString());
				}
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	
}
