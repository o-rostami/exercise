package com.example.exercise.service.product;

import java.util.List;

import com.example.exercise.api.product.ProductResource;
import com.example.exercise.api.request.product.ProductSearchDto;
import com.example.exercise.api.response.product.ProductSearchResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductResourceIT {

	@Autowired
	ProductResource productResource;

	@Test
	@DisplayName("review - call review method and return all 6 record successfully")
	public void review1() {
		ResponseEntity<ProductSearchResponse> response = productResource.review(0, 10, new ProductSearchDto());
		assertThat(response).isNotNull(); assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull(); assertThat(response.getBody().getData()).isNotNull();
		assertThat(response.getBody().getData().getTotalElements()).isEqualTo(6);
	}

	@Test
	@DisplayName("Call the review method with a filter on the provider name that uses the contains operation, so that" + "  it returns four records successfully. These records have been gathered as a joined product to the " + "provider table")
	public void review2() {
		String providerName = "prodiver1"; SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setOperation("cn"); searchCriteria.setFilterKey("providerName");
		searchCriteria.setValue(providerName);

		ProductSearchDto productSearchDto = new ProductSearchDto(); productSearchDto.setDataOption("all");
		productSearchDto.setSearchCriteriaList(List.of(searchCriteria));

		ResponseEntity<ProductSearchResponse> response = productResource.review(0, 10, productSearchDto);
		assertThat(response).isNotNull(); assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull(); assertThat(response.getBody().getData()).isNotNull();
		assertThat(response.getBody().getData().getTotalElements()).isEqualTo(4);
		response.getBody().getData().getContent().forEach(item -> assertThat(item.getProviderName()).isEqualTo(providerName));
	}

	@Test
	@DisplayName("Call the review method with a filter on filed which is not correct so that get error")
	public void review3() {
		String providerName = "prodiver1";
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setOperation("cn");
		searchCriteria.setFilterKey("lastName");
		searchCriteria.setValue(providerName);
		ProductSearchDto productSearchDto = new ProductSearchDto();
		productSearchDto.setDataOption("all");
		productSearchDto.setSearchCriteriaList(List.of(searchCriteria));
		Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> productResource.review(0, 10, productSearchDto));
	}

}
