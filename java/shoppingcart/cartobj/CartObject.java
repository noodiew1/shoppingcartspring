package shoppingcart.cartobj;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class CartObject implements Serializable {
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	private int itemId;
	private int quantity;
	private int customerId;

	public CartObject() {
		id = 0;
		itemId = 0;
		quantity = 0;
		customerId = 0;
	}
	public CartObject(int inputId, int inputItemId, int inputQuantity, int inputCustomerId) {
		id = inputId;
		itemId = inputItemId;
		quantity = inputQuantity;
		customerId = inputCustomerId;
	}
	public int getOrderId() {
		return id;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("OrderId: ").append(id).append(", ")
			.append("ItemId: ").append(itemId).append(", ")
			.append("quantity: ").append(quantity).append(",")
			.append("CustomerId: ").append(customerId);
		return sb.toString();
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof CartObject)) return false;
	    CartObject cart = (CartObject) o;
	    return getOrderId() == cart.getOrderId();
	}
	
	
}
