package shoppingcart;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class SpringBootH2DatabaseExampleApplicationTests {

	@Autowired
	SpringBootH2DatabaseExampleApplication SpringBootH2DatabaseExampleApplicationTests;

	@MockBean
	CartObjectRepository cor;

	@Test
	public void run_test_call() {
		//verify(shoppingItemSelectService, times(1)).simulateBatchItemSelect();
		when(cor.save(any(CartObject.class)))
        .thenReturn(null);
	}

}
