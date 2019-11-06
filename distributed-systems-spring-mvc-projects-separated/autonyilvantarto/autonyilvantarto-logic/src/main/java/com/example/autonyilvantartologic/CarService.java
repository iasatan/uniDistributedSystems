package com.example.autonyilvantartologic;

import java.util.List;

public interface CarService {

    List<Car> getCarList();

    void add(Car car);

    Car getCarById(int id);

    Car getCarByLicensePlateNumber(String plate);


}
