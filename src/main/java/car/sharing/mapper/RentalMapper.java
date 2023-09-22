package car.sharing.mapper;

import car.sharing.config.mappers.MapperConfig;
import car.sharing.dto.request.RentalRequestDto;
import car.sharing.dto.response.RentalResponseDto;
import car.sharing.entity.Car;
import car.sharing.entity.Rental;
import car.sharing.entity.User;
import car.sharing.service.CarService;
import car.sharing.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public abstract class RentalMapper {
    private CarService carService;
    private UserService userService;

    @Mapping(target = "car", source = "requestDto.carId", qualifiedByName = "getCarById")
    @Mapping(target = "user", source = "requestDto.userId", qualifiedByName = "getUserById")
    public abstract Rental mapToEntity(RentalRequestDto requestDto);

    @Mapping(source = "car", target = "carId")
    @Mapping(source = "user", target = "userId")
    public abstract RentalResponseDto mapToDto(Rental rental);

    @Named("getCarById")
    protected Car getCarById(Long carId) {
        return carService.getById(carId);
    }

    @Named("getUserById")
    protected User getUserById(Long userId) {
        return userService.getById(userId);
    }

    protected Long mapCarToId(Car car) {
        return car.getId();
    }

    protected Long mapUserToId(User user) {
        return user.getId();
    }
}
