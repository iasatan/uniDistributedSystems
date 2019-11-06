package com.example.autonyilvantartoweb;

import com.example.autonyilvantartologic.Car;
import com.example.autonyilvantartologic.CarService;
import com.example.autonyilvantartologic.exception.InvalidCarException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CarRestController {

    private final CarService carService;

    @GetMapping()
    public List<Car> getCarList() {
        return carService.getCarList();
    }

    @GetMapping("getCarById/{id}")
    public Car getCarById(@PathVariable Integer id) {
        return carService.getCarById(id);
    }


    @GetMapping("getCarByLicensePlateNumber")
    public Car getCarByLicensePlateNumber(String plate) {
        System.out.println(plate);
        return carService.getCarByLicensePlateNumber(plate);
    }

    @PostMapping("add")
    public void add(@Valid Car car, BindingResult bindingResult) throws InvalidCarException {
        if (bindingResult.hasErrors()) {
            throw new InvalidCarException();
        } else {
            carService.add(car);
        }
    }

    @ExceptionHandler(value = InvalidCarException.class)
    public String notValidCar() {
        return "Car is not valid";
    }


}
