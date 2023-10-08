package springdatajpa.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springdatajpa.entity.Address;
import springdatajpa.entity.Customer;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {
        Customer customer = Customer.builder()
                                    .firstName("ssssssssss")
                                    .lastName("ssssssssssssss")
                                    .email("ssssssssss@gmail.com")
                                    .build();
        customerRepository.save(customer);
    }

    @Test
    void findByFirstName() {
        Customer customer = customerRepository.findByFirstName("Jonathan")
                                              .get();
        System.out.println("customer = " + customer);
    }

    @Test
    void findAll() {
        List<Customer> customerList = customerRepository.findAll();
        System.out.println("customerList = " + customerList);
    }

    @Test
    void saveWithAddressEmbbeded() {
        Address address = Address.builder()
                                 .city("Xd")
                                 .mainStreet("XD A. Amazonas")
                                 .secondaryStreet("Av. lol")
                                 .build();
        Customer customer = Customer.builder()
                                    .firstName("hola")
                                    .email("hola@gmail.com")
                                    .address(address)
                                    .build();
       /* Customer customer2 = Customer.builder()
                                     .firstName("sander")
                                     .lastName("io")
                                     .email("sander@gmail.com")
                                     .address(address)
                                     .build();
        Customer customer3 = Customer.builder()
                                     .firstName("tata")
                                     .lastName("wtf")
                                     .email("tata@gmail.com")
                                     .address(address)
                                     .build();*/
        customerRepository.save(customer);/*
        customerRepository.save(customer2);
        customerRepository.save(customer3);*/
    }

    @Test
    void findByFirstNameContains() {
        List<Customer> customerList = customerRepository.findByFirstNameContains("ta");
        System.out.println("customerList = " + customerList);
    }

    @Test
    void findByLastNameNotNull() {
        List<Customer> customerList = customerRepository.findByLastNameNotNull();
        System.out.println("customerList = " + customerList);
    }

    @Test
    void findByAddress_City() {
        List<Customer> customerList = customerRepository.findByAddress_City("Ambato");
        System.out.println("customerList = " + customerList);
    }

    @Test
    void findByEmail() {
        Optional<Customer> customerOptional = customerRepository.findByEmail("tata@gmail.com");
        System.out.println("customerList = " + customerOptional.get());
    }

    @Test
    void findFirstNameByEmail() {
        String firstName = customerRepository.findFirstNameByEmail("tata@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    void findByEmailNative() {
        Optional<Customer> customerOptional = customerRepository.findByEmailNative("tata@gmail.com");
        System.out.println("customerList = " + customerOptional.get());
    }

    @Test
    void updateFirstNameByEmail() {
        customerRepository.updateFirstNameByEmail("tata2", "tata@gmail.com");
    }
}