package org.jsp.SupplyChainManagement.repository;
import java.util.List;

import org.jsp.SupplyChainManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select p from Product p where p.supplier.id=?1")
	List<Product> getProductBySupplierId(int id);
}

