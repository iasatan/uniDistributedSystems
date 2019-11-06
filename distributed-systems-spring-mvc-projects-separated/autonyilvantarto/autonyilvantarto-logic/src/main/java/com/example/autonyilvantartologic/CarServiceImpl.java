package com.example.autonyilvantartologic;

import com.example.autonyilvantartologic.exception.CarNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private Map<Integer, Car> carMap = new HashMap<>();

    @PostConstruct
    private void initialize() {
        carMap.put(1, Car.builder().id(1).licensePlateNumber("ABC-123").build());
        carMap.put(2, Car.builder().id(2).licensePlateNumber("DEF-456").build());
        carMap.put(3, Car.builder().id(4).licensePlateNumber("GHI-789").build());
        carMap.put(4, Car.builder().id(3).licensePlateNumber("ASD-666").build());
    }

    @Override
    public List<Car> getCarList() {
        return Collections.unmodifiableList(new ArrayList<>(carMap.values()));
    }

    @Override
    public void add(Car car) {
        carMap.put(car.getId(), car);
    }

    @Override
    public Car getCarById(int id) {
        return carMap.get(id);
    }

    @Override
    public Car getCarByLicensePlateNumber(String plate) {
        List<Car> carList = new ArrayList<>(carMap.values());
        for (Car car : carList) {
            if (car.getLicensePlateNumber().equals(plate)) {
                return car;

            }

        }
        throw new CarNotFoundException();
    }


}
