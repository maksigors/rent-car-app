package car.sharing.service;

import car.sharing.entity.Car;

public interface CarService extends AbstractService<Car> {
    Car increaseInventory(Car car);

    Car decreaseInventory(Car car);
}
