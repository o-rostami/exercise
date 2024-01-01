package com.example.exercise.model.provider;

import java.util.Date;
import java.util.Set;

import com.example.exercise.model.product.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "tbl_provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String providerName;

	private String address;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provider", cascade = CascadeType.ALL)
	private Set<Product> products;

	@Version
	private Long version;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

}
