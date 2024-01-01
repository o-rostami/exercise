package com.example.exercise.service.product.impl;

import java.util.List;

import com.example.exercise.api.request.product.ProductSearchDto;
import com.example.exercise.model.product.Product;
import com.example.exercise.model.product.dao.ProductRepository;
import com.example.exercise.model.product.dao.ProductSpecificationBuilder;
import com.example.exercise.service.product.ProductService;
import com.example.exercise.service.product.SearchCriteria;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {


	private final ProductRepository productRepository;

	// Save operation
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Read operation
	@Override
	public List<Product> fetchProductList(Integer page, Integer size) {
		return (List<Product>) productRepository.findAll(PageRequest.of(page, size));
	}

	// Update operation
	@Override
	public Product updateProduct(Product product, Long productId) {
		Product purDB = productRepository.findById(productId).get(); return productRepository.save(purDB);
	}

	// Delete operation
	@Override
	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> fetchAll() {
		return productRepository.findAll();
	}

	@Override
	public Page<Product> findBySearchCriteria(ProductSearchDto productSearchDto, int pageNum, int pageSize) {

		ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
		List<SearchCriteria> criteriaList = productSearchDto.getSearchCriteriaList(); if (criteriaList != null) {
			criteriaList.forEach(x -> {
				x.setDataOption(productSearchDto.getDataOption()); builder.with(x);
			});
		} Pageable page = PageRequest.of(pageNum, pageSize);
		return productRepository.findAll(builder.build(), page);
	}
}