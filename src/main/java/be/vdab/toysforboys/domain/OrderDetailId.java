package be.vdab.toysforboys.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "orderId")
    private long orderId;

    @Column(name = "productId")
    private long productId;

    protected OrderDetailId() {
    }

    public OrderDetailId(long orderId, long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getProductId() {
        return productId;
    }


}
