package be.heh.testarchitecturehexa.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class Car {

    @Getter
    private final String marque;
    @Getter
    private final String model;
    @Getter
    private final Integer age;

}
