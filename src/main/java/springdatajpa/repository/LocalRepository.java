package springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatajpa.entity.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}