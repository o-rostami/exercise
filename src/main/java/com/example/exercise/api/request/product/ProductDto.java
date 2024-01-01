package com.example.exercise.api.request.product;

import java.util.stream.Stream;

import com.example.exercise.model.product.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ProductDto {

	private String name;

	private boolean enabled;

	private Integer averageRate;

	private CommentType commentType;

	private VoteType voteType;

	private String providerName;


	@RequiredArgsConstructor
	public enum CommentType {
		EVERYBODY(0), BUYERS(1);

		private final int value;


		@JsonCreator
		public static Product.CommentType fromValue(int value) {
			return Stream.of(Product.CommentType.values()).filter(type -> type.getValue() == value).findFirst().orElseThrow(() -> new RuntimeException("invalid coomment type found -> " + value));
		}

		@JsonValue
		public int toValue() {
			return value;
		}

	}


	@RequiredArgsConstructor
	public enum VoteType {

		EVERYBODY(0), BUYERS(1);

		private final int value;

		@JsonCreator
		public static Product.VoteType fromValue(int value) {
			return Stream.of(Product.VoteType.values()).filter(type -> type.getValue() == value).findFirst().orElseThrow(() -> new RuntimeException("invalid vote type found -> " + value));
		}

		@JsonValue
		public int toValue() {
			return value;
		}
	}
}
