package car.sharing.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import car.sharing.dto.request.CarRequestDto;
import car.sharing.dto.response.CarResponseDto;
import car.sharing.entity.Car;
import car.sharing.mapper.CarMapper;
import car.sharing.service.CarService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @Operation(summary = "Get all car", description = "List of all car")
    @GetMapping("/")
    public List<CarResponseDto> getAll() {
        return carService.getAll().stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get car by id", description = "Get car by id")
    @GetMapping("/{id}")
    public CarResponseDto get(@PathVariable Long id) {
        return carMapper.toDto(carService.getById(id));
    }

    @Operation(summary = "Add car", description = "Creation of the essence of the car")
    @PostMapping
    public CarResponseDto add(@Valid @RequestBody CarRequestDto dto) {
        return carMapper.toDto(carService.add(carMapper.toEntity(dto)));
    }

    @Operation(summary = "Delete car by id", description = "Delete car by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @Operation(summary = "Update car by id", description = "Update car by id")
    @PutMapping("/{id}")
    public CarResponseDto updateCar(@PathVariable Long id,
                                    @Valid @RequestBody CarRequestDto dto) {
        Car carFromDto = carMapper.toEntity(dto);
        carFromDto.setId(id);
        return carMapper.toDto(carService.update(carFromDto));
    }
}
