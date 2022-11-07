package be.heh.testarchitecturehexa.adaptater.in;

import be.heh.testarchitecturehexa.model.Car;
import be.heh.testarchitecturehexa.port.in.CarListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarListUseCase carListUseCase;
    private List<Car> cars;

    @GetMapping("/")
    public String carList(Model model){
        cars = carListUseCase.getCarList();
        model.addAttribute("cars",cars);
        return "carList";
    }
}
