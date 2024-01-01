package com.example.exercise.model.purchase;

import java.util.Date;
import java.util.stream.Stream;

import com.example.exercise.model.product.Product;
import com.example.exercise.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "tbl_purchase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Status status;


	@ManyToOne
	@JoinColumn(name = "product_id", nullable = true)
	private Product product;


	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	@Version
	private Long version;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;


	@Getter
	@RequiredArgsConstructor
	public enum Status {
		INITIATED(0), CONFIRMED(1);

		private final int value;

		public static Status fromValue(int value) {
			return Stream.of(Status.values()).filter(type -> type.value == value).findFirst().orElseThrow(() -> new RuntimeException("invalid Status type found -> " + value));
		}
	}

}
