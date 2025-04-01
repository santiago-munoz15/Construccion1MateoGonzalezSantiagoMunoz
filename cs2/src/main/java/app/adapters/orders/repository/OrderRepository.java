package app.adapters.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	

}
