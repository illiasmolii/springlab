package ua.skillsup.jp1.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Id implements Serializable {

		@Column(name = "ORDER_ID", nullable = false)
		private Long orderId;

		@Column(name = "PRODUCT_ID", nullable = false)
		private Long productId;
	}

	@EmbeddedId
	private Id id;

	@ManyToOne
	@JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
	private Product product;

	@Column(name = "COUNT", nullable = false)
	private Integer count;
}
