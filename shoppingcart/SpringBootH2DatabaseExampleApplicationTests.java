package shoppingcart;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import shoppingcart.cartobj.CartObjectRepository;
import shoppingcart.message.MessageReceiverCartObject;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class SpringBootH2DatabaseExampleApplicationTests {

	@Autowired
	SpringBootH2DatabaseExampleApplication springBootH2DatabaseExampleApplication;

	//@MockBean
	//ShoppingItemSelectService shoppingItemSelectService;

	@Test
	public void run_test_call() {
		//verify(shoppingItemSelectService, times(1)).simulateBatchItemSelect();
	}

}
