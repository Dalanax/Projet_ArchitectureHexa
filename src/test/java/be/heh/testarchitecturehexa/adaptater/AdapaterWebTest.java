package be.heh.testarchitecturehexa.adaptater;

import be.heh.testarchitecturehexa.adaptater.in.CarController;
import be.heh.testarchitecturehexa.model.Car;
import be.heh.testarchitecturehexa.port.in.CarListUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class AdapaterWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarListUseCase carListUseCase;

    private List<Car> cars = new ArrayList<>();

    @Test
    public void testCarController() throws Exception {

        cars.add(new Car("tata","titi", 2));
        cars.add(new Car("tata1","titi1", 6));
        cars.add(new Car("tata2","titi2", 30));

        //Stub
        Mockito.when(carListUseCase.getCarList()).thenReturn(cars);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("carList"))
                .andExpect(model().attributeExists("cars"))
                .andExpect(model().attribute("cars",Matchers.hasSize(3)));
    }
}