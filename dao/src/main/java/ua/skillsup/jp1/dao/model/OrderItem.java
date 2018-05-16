package ua.skillsup.jp1.dao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Id implements Serializable {

		@Column(name = "ORDER_ID", nullable = false)
		protected Long orderId;

		@Column(name = "PRODUCT_ID", nullable = false)
		protected Long productId;
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

	public OrderItem() {
	}

	public OrderItem(Id id, Order order, Product product, Integer count) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.count = count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof OrderItem)) {
			return false;
		}
		OrderItem orderItem = (OrderItem) o;
		return Objects.equals(id, orderItem.id) &&
				Objects.equals(order, orderItem.order) &&
				Objects.equals(product, orderItem.product) &&
				Objects.equals(count, orderItem.count);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, order, count);
	}
}
