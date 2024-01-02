package com.example.exercise.model.product.dao;

import java.util.Objects;

import com.example.exercise.model.product.Product;
import com.example.exercise.model.provider.Provider;
import com.example.exercise.service.product.SearchCriteria;
import com.example.exercise.service.product.SearchOperation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification implements Specification<Product> {
	private final SearchCriteria searchCriteria;

	public ProductSpecification(final SearchCriteria searchCriteria) {
		super(); this.searchCriteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		String strToSearch = searchCriteria.getValue().toString().toLowerCase();

		switch (Objects.requireNonNull(SearchOperation.getSimpleOperation(searchCriteria.getOperation()))) {
			case CONTAINS:
				if (searchCriteria.getFilterKey().equals("providerName")) {
					return cb.like(cb.lower(providerJoin(root).<String>get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");
				} return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");

			case DOES_NOT_CONTAIN:
				if (searchCriteria.getFilterKey().equals("providerName")) {
					return cb.notLike(cb.lower(providerJoin(root).<String>get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");
				} return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");

		}
		//todo complete all other operation later

		return null;
	}

	private Join<Product, Provider> providerJoin(Root<Product> root) {
		return root.join("provider");
	}

}