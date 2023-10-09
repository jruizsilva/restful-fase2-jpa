package springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springdatajpa.entity.Manager;

import java.util.List;

@SpringBootTest
class ManagerRepositoryTest {
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void findAll() {
        Manager manager = Manager.builder()
                                 .firstName(" manager name xd")
                                 .lastName(" manager Apellido xd")
                                 .build();

        managerRepository.save(manager);
        List<Manager> managerList = managerRepository.findAll();
        System.out.println("managerList = " + managerList);
    }
}