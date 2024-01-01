package com.example.exercise.api.product.mapper;

import java.util.List;

import com.example.exercise.api.request.product.ProductDto;
import com.example.exercise.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductResourceMapper {

	@Mapping(target = "provider", ignore = true)
	@Mapping(target = "votes", ignore = true)
	@Mapping(target = "voteType", ignore = true)
	@Mapping(target = "commentType", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	@Mapping(target = "items", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "averageRate", ignore = true)
	Product toProduct(ProductDto productDto);

	@Mapping(target = "providerName", source = "product.provider.providerName")
	ProductDto toProductDto(Product product);

	default List<ProductDto> toProductDto(List<Product> products) {
		return products.stream().map(this::toProductDto).toList();
	}
}
