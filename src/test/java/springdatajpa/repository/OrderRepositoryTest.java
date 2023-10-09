package springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springdatajpa.entity.Local;
import springdatajpa.entity.Manager;
import springdatajpa.entity.Order;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    void save() {
        Manager manager = Manager.builder()
                                 .firstName("nuevo manager")
                                 .lastName("test apellido")
                                 .build();
        Local local = Local.builder()
                           .name("Binco")
                           .floor("4")
                           .manager(manager)
                           .build();
        Order order = Order.builder()
                           .description("Binco")
                           .price(10.0)
                           .local(local)
                           .build();

        orderRepository.save(order);
    }

}