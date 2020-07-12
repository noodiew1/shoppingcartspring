package shoppingcart.message;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import shoppingcart.cartobj.CartObject;

import shoppingcart.cartobj.CartObjectRepository;



@Component
public class MessageCreatorCartObject implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	
	public void run(String... arg0) throws Exception {
		// This will put text message to queue
		CartObject ca = new CartObject();
		Thread.sleep(5000);
		this.jmsMessagingTemplate.convertAndSend("CART_QUEUE.ACTIVE_QUEUE", ca);
		System.out.println("Message has been put to queue by sender");
	}
}