package com.example.exercise.api.product;

import com.example.exercise.api.product.mapper.ProductResourceMapper;
import com.example.exercise.api.request.product.ProductDto;
import com.example.exercise.api.request.product.ProductSearchDto;
import com.example.exercise.api.response.product.ProductSearchResponse;
import com.example.exercise.model.product.Product;
import com.example.exercise.service.product.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductResource {


	private final ProductService productService;

	private final ProductResourceMapper mapper;


	@PostMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductSearchResponse> review(@RequestParam(name = "pageNum", defaultValue = "0") final Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") final Integer pageSize, @RequestBody ProductSearchDto productSearchDto) {
		log.info("got review request with: {}", productSearchDto);
		Page<Product> productPage = productService.findBySearchCriteria(productSearchDto, pageNum, pageSize);
		Page<ProductDto> result = new PageImpl<>(mapper.toProductDto(productPage.stream().toList()), productPage.getPageable(), productPage.getTotalElements());
		log.info(" product result successfully with: {}", result);
		return ResponseEntity.ok(new ProductSearchResponse(result));
	}
}