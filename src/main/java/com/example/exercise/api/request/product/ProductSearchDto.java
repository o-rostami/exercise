package com.example.exercise.api.request.product;

import java.util.List;

import com.example.exercise.service.product.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchDto {

	private List<SearchCriteria> searchCriteriaList;

	private String dataOption;

}