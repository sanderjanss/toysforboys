package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String scale;
    private String description;
    private long inStock;
    private long inOrder;
    private BigDecimal price;
    private long version;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productlineId")
    private Productline productline;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    protected Product() {
    }

    public Product(String name, String scale, String description, long inStock, long inOrder, BigDecimal price, long version) {
        this.name = name;
        this.scale = scale;
        this.description = description;
        this.inStock = inStock;
        this.inOrder = inOrder;
        this.price = price;
        this.version = version;
        this.orderDetails = new LinkedHashSet<>();
    }

    public Set<OrderDetail> getOrderDetails() {
        return Collections.unmodifiableSet(orderDetails);
    }

    public Productline getProductline() {
        return productline;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScale() {
        return scale;
    }

    public String getDescription() {
        return description;
    }

    public long getInStock() {
        return inStock;
    }

    public long getInOrder() {
        return inOrder;
    }

    public BigDecimal getPrice() {
        return price.setScale(1, RoundingMode.UP);
    }



    public long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
