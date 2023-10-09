package springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springdatajpa.entity.Local;
import springdatajpa.entity.Manager;

import java.util.List;

@SpringBootTest
class LocalRepositoryTest {
    @Autowired
    private LocalRepository localRepository;

    private void addLocal() {
        Manager manager = Manager.builder()
                                 .firstName("Nombre manager")
                                 .lastName("Apellido manager")
                                 .build();
        Local local = Local.builder()
                           .name("PetShop")
                           .floor("2")
                           .manager(manager)
                           .build();
        localRepository.save(local);
    }

    @Test
    void save() {
        addLocal();
    }

    @Test
    void findAll() {
        List<Local> localList = localRepository.findAll();
        System.out.println("localList = " + localList);
    }
}