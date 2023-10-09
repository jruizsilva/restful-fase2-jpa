package springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springdatajpa.entity.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.firstName = :firstName")
    Optional<Customer> findByFirstName(String firstName);
    @Query("select c from Customer c where c.firstName like concat('%', ?1, '%')")
    List<Customer> findByFirstNameContains(String firstName);
    @Query("select c from Customer c where c.lastName is not null")
    List<Customer> findByLastNameNotNull();
    @Query("select c from Customer c where c.address.city = ?1")
    List<Customer> findByAddress_City(String city);
    /*@Query("select c from Customer c where c.email = ?1")
    Optional<Customer> findByEmail(String email);*/
    @Query("select c.firstName from Customer c where c.email = ?1")
    String findFirstNameByEmail(String email);

    @Query("select c from Customer c where c.email = :email")
    Optional<Customer> findByEmail(@Param("email") String email);

    @Query(value = "select * from customers where email_address = :email",
           nativeQuery = true)
    Optional<Customer> findByEmailNative(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("update Customer c set c.firstName = :firstName where c.email = :email")
    void updateFirstNameByEmail(@Param("firstName") String firstName,
                                @Param("email") String email);

}
