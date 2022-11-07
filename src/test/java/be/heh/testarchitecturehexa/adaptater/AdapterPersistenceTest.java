package be.heh.testarchitecturehexa.adaptater;

import be.heh.testarchitecturehexa.adaptater.out.CarMapper;
import be.heh.testarchitecturehexa.adaptater.out.CarPersistenceAdapter;
import be.heh.testarchitecturehexa.adaptater.out.CarRepository;
import be.heh.testarchitecturehexa.model.Car;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistenceTest extends AbstractIntegrationTest{

    @Autowired
    private CarRepository carRepository;
    private  CarMapper carMapper;

    private CarPersistenceAdapter carPersistenceAdapter;

    @Test
    @Sql({"createCarTable.sql","dataCar.sql"})
    void getCarsList(){
        carMapper = new CarMapper();
        carPersistenceAdapter = new CarPersistenceAdapter(carRepository,carMapper);

        List<Car> cars;

        cars = carPersistenceAdapter.getCarList();


        assertEquals("tata1",cars.get(1).getMarque());
        assertEquals("tutu1",cars.get(1).getModel());
        assertEquals(200,cars.get(1).getAge());
    }
}
