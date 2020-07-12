package shoppingcart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringBootH2DatabaseExampleApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
	}
	
	@Bean
	public Queue activeQueue() {
		return new ActiveMQQueue("CART_QUEUE.ACTIVE_QUEUE");
	}
	
	@Bean
	public Queue rejoinQueue() {
		return new ActiveMQQueue("CART_QUEUE.REJOIN_QUEUE");
	}
}
