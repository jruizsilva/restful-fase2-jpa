package springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springdatajpa.entity.Customer;
import springdatajpa.entity.Local;
import springdatajpa.entity.Manager;
import springdatajpa.entity.Order;

import java.util.List;

@SpringBootTest
class LocalRepositoryTest {
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void save() {
        Manager manager = Manager.builder()
                                 .firstName(" manager name xd")
                                 .lastName(" manager Apellido xd")
                                 .build();
        Local local = Local.builder()
                           .name("PetShop 23213")
                           .floor("24232")
                           .manager(manager)
                           .build();
        localRepository.save(local);

        List<Manager> managerList = managerRepository.findAll();
        System.out.println("managerList = " + managerList);
        managerList.forEach(el -> {
            System.out.println("el.getManager() = " + el.getLocal());
        });
    }

    @Test
    void findAll() {
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
        localList.forEach(local -> {
            System.out.println("local.getManager() = " + local.getManager());
        });
    }

    @Test
    void saveLocalWithOrders() {
        Manager manager = Manager.builder()
                                 .firstName("manager name")
                                 .lastName("manager apellido")
                                 .build();

        Order order1 = Order.builder()
                            .description("cine description")
                            .price(15.0)
                            .build();
        Order order2 = Order.builder()
                            .description("parque description")
                            .price(15.0)
                            .build();

        Local local = Local.builder()
                           .name("PetShop 23213")
                           .floor("24232")
                           .manager(manager)
                           /*.orderList(List.of(order1, order2))*/
                           .build();

        localRepository.save(local);
    }

    @Test
    void findAllLocalsWithOrders() {
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
    }

    @Test
    void saveLocalWithCustomers() {
        Manager manager = Manager.builder()
                                 .firstName("Best manager las")
                                 .lastName("teemo op")
                                 .build();
        Customer customer1 = Customer.builder()
                                     .firstName("Juan")
                                     .lastName("Noa")
                                     .email("juan@gmail.com")
                                     .build();
        Customer customer2 = Customer.builder()
                                     .firstName("Eddie")
                                     .lastName("Poe")
                                     .email("eddie@gmail.com")
                                     .build();
        Local local = Local.builder()
                           .name("Clukin Bell")
                           .floor("1 piso")
                           .customers(List.of(customer1, customer2))
                           .manager(manager)
                           .build();

        localRepository.save(local);
    }

    @Test
    void findAllLocalsWithCustomers() {
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
        localList.forEach(local -> {
            System.out.println("local.getCustomers() = " + local.getCustomers());
        });
        localList.forEach(local -> {
            System.out.println("local.getManager() = " + local.getManager());
        });

    }

    @Test
    void findCustomersByLocal() {
        Local local = localRepository.findById(6L)
                                     .get();
        List<Customer> customerList = local.getCustomers();
        System.out.println("customerList = " + customerList);
    }
}