package app.ports;

import java.util.List;

import app.domain.models.Order;

public interface OrderPort {
	
	public void saveOrder(Order order) throws Exception;
	Order findById(long orderId) throws Exception;
	public void updateOrder(Order order) throws Exception;
	List<Order> getAllOrders();

}
