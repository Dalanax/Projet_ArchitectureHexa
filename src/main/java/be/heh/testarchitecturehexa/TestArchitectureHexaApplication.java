package be.heh.testarchitecturehexa;

import be.heh.testarchitecturehexa.adaptater.out.CarMapper;
import be.heh.testarchitecturehexa.adaptater.out.CarPersistenceAdapter;
import be.heh.testarchitecturehexa.adaptater.out.CarRepository;
import be.heh.testarchitecturehexa.port.in.CarListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestArchitectureHexaApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestArchitectureHexaApplication.class, args);
    }

}
