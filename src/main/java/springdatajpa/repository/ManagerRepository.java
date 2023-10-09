package springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatajpa.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}