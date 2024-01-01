package com.example.exercise.service.product;

import java.util.List;

import com.example.exercise.api.request.product.ProductSearchDto;
import com.example.exercise.model.product.Product;

import org.springframework.data.domain.Page;

public interface ProductService {

	// Save operation
	Product saveProduct(Product product);

	// Read operation
	List<Product> fetchProductList(Integer page, Integer size);
	List<Product> fetchAll();

	// Update operation
	Product updateProduct(Product product, Long productId);

	// Delete operation
	void deleteProductById(Long productId);

	Page<Product> findBySearchCriteria(ProductSearchDto productSearchDto, int pageNum, int pageSize);
}