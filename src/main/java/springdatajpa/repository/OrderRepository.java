package springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatajpa.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}