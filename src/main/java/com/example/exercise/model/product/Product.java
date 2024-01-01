package com.example.exercise.model.product;

import java.util.Date;
import java.util.Set;
import java.util.stream.Stream;

import com.example.exercise.model.comment.Comment;
import com.example.exercise.model.provider.Provider;
import com.example.exercise.model.vote.Vote;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "tbl_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private boolean enabled;

	private Integer averageRate;

	private CommentType commentType;

	private VoteType voteType;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Comment> items;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Vote> votes;

	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = false)
	private Provider provider;

	@Version
	private Long version;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;


	@Getter
	@RequiredArgsConstructor
	public enum CommentType {
		EVERYBODY(0), BUYERS(1);

		private final int value;

		public static CommentType fromValue(int value) {
			return Stream.of(CommentType.values()).filter(type -> type.value == value).findFirst().orElseThrow(() -> new RuntimeException("invalid coomment type found -> " + value));
		}
	}


	@Getter
	@RequiredArgsConstructor
	public enum VoteType {

		EVERYBODY(0), BUYERS(1);

		private final int value;

		public static VoteType fromValue(int value) {
			return Stream.of(VoteType.values()).filter(type -> type.value == value).findFirst().orElseThrow(() -> new RuntimeException("invalid vote type found -> " + value));
		}
	}
}
