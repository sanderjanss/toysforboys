package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {
    private EntityManager entityManager;

    public JpaOrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Order> findById(long id) {
        return Optional.ofNullable(entityManager.find(Order.class, id));
    }

    @Override
    public List<Order> findUnshipped() {
        return entityManager.createQuery("select o from Order o where o.status not in ('CANCELLED','SHIPPED') order by o.ordered asc", Order.class)
                .getResultList();
    }
}
