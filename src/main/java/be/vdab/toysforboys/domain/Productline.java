package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "productlines")
public class Productline implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private long version;

    @OneToMany(mappedBy = "productline")
    private Set<Product> products;

    protected Productline() {
    }

    public Productline(String name, String description, long version) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.products = new LinkedHashSet<>();
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getVersion() {
        return version;
    }
}
