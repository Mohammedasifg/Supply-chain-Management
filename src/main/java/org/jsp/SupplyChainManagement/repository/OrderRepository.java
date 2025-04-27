package org.jsp.SupplyChainManagement.repository;
import java.util.List;
import java.util.Optional;
import org.jsp.SupplyChainManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query("select o from Order o where o.customer.id=?1")
	List<Order> getOrdersByCustomerId(int id);
	
	@Query("select o from Order o where o.trackingNumber=?1")
	Optional<Order> getOrderByTrakingNumber(String trackingNumber);
}
