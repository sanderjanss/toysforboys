package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderDetailId orderDetailId;
    private long ordered;
    private BigDecimal priceEach;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId", insertable=false, updatable=false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", insertable=false, updatable=false)
    private Product product;


    public OrderDetail(OrderDetailId orderDetailId, long ordered, BigDecimal priceEach) {
        this.orderDetailId = orderDetailId;
        this.ordered = ordered;
        this.priceEach = priceEach;
    }

    protected OrderDetail() {
    }

    public OrderDetailId getOrderDetailId() {
        return orderDetailId;
    }

    public long getOrdered() {
        return ordered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(orderDetailId, that.orderDetailId) &&
                Objects.equals(ordered, that.ordered) &&
                Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailId, ordered, priceEach);
    }
}
