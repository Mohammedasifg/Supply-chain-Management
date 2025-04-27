package org.jsp.SupplyChainManagement.repository;
import org.jsp.SupplyChainManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
