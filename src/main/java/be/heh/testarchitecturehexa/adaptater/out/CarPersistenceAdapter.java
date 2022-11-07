package be.heh.testarchitecturehexa.adaptater.out;

import be.heh.testarchitecturehexa.model.Car;
import be.heh.testarchitecturehexa.port.in.CarListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CarPersistenceAdapter implements CarListUseCase {

    private final CarRepository carRepository;
    private List<Car> cars;

    private final CarMapper carMapper;

    @Override
    public List<Car> getCarList() {
        List<CarJpaEntity> carEntity = carRepository.findAll();
        return carMapper.mapToDomainEntity(carEntity);
    }
}
