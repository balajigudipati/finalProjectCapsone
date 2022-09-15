package com.example.projectCode.repository;





//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectCode.entity.ProductDetails;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
	
	
	ProductDetails findByproductId(String producId);
	
	ProductDetails findByproductName(String productName);
	
	ProductDetails findById(long id);
	
	ProductDetails findByProductCategory(String productCategory);
	


	
}
