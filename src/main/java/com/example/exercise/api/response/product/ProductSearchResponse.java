package com.example.exercise.api.response.product;

import com.example.exercise.api.request.product.ProductDto;
import com.example.exercise.api.response.BaseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchResponse extends BaseService {

	Page<ProductDto> data;
}
