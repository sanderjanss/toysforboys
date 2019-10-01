package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long version;

    @OneToMany(mappedBy = "country")
    private Set<Customer> customers;

    protected Country() {
    }

    public Country(String name, long version) {
        this.name = name;
        this.version = version;
        this.customers = new LinkedHashSet<>();
    }

    public Set<Customer> getCustomers() {
        return Collections.unmodifiableSet(customers);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getVersion() {
        return version;
    }
}
