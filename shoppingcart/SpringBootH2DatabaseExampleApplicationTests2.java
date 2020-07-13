package shoppingcart;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import shoppingcart.cartobj.CartObject;
import shoppingcart.cartobj.CartObjectRepository;
import shoppingcart.message.MessageReceiverCartObject;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {
		SpringBootH2DatabaseExampleApplication.class,
	    CartObjectRepository.class
	    
})
//comment
@SpringBootTest
@ActiveProfiles("test")
class SpringBootH2DatabaseExampleApplicationTests2 {

	@Autowired
	SpringBootH2DatabaseExampleApplication SpringBootH2DatabaseExampleApplicationTests;

	@Autowired
	CartObjectRepository cor;

	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;

	
	@Test
	public void run_test_save_return_not_null() {
		//verify(shoppingItemSelectService, times(1)).simulateBatchItemSelect();
		for (int i=0;i<5;i++) {
			CartObject ca = new CartObject();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.jmsMessagingTemplate.convertAndSend("CART_QUEUE.ACTIVE_QUEUE", ca);
			System.out.println("Message has been put to queue by sender");
		}
	}

}
