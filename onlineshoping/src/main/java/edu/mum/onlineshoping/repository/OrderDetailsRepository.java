package edu.mum.onlineshoping.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlineshoping.model.OrderDetails;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long>{

	@Query("select o from OrderDetails o where o.product.id = :id")
	OrderDetails findByProductId(@Param("id") long id);
}
