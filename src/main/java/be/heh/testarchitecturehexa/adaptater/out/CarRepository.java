package be.heh.testarchitecturehexa.adaptater.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarJpaEntity,Long> {

}