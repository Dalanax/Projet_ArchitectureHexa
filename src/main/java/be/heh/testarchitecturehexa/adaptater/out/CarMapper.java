package be.heh.testarchitecturehexa.adaptater.out;

import be.heh.testarchitecturehexa.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {

    List<Car> mapToDomainEntity(List<CarJpaEntity> cars){
        List<Car> carsList = new ArrayList<>();

        for (CarJpaEntity carJpaEntity: cars) {
            carsList.add(new Car(carJpaEntity.getMarque(),carJpaEntity.getModel(),carJpaEntity.getAge()));
        }
        return carsList;
    }
}
