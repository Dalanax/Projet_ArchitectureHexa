package be.heh.testarchitecturehexa;

import be.heh.testarchitecturehexa.adaptater.out.CarMapper;
import be.heh.testarchitecturehexa.adaptater.out.CarPersistenceAdapter;
import be.heh.testarchitecturehexa.adaptater.out.CarRepository;
import be.heh.testarchitecturehexa.port.in.CarListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
        @Autowired
        private CarRepository carRepository;

        private CarMapper carMapper = new CarMapper();

        @Bean
        CarListUseCase getCarListUseCase(){

            return new CarPersistenceAdapter(carRepository,carMapper);
        }

}
