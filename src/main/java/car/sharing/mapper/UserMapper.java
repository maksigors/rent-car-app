package car.sharing.mapper;

import car.sharing.config.mappers.MapperConfig;
import car.sharing.dto.request.UserRegistrationDto;
import car.sharing.dto.request.UserRequestDto;
import car.sharing.dto.response.UserResponseDto;
import car.sharing.entity.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User mapToEntity(UserRegistrationDto dto);

    User mapToEntity(UserRequestDto dto);

    UserResponseDto mapToDto(User user);
}
