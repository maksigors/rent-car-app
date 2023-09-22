package car.sharing.service;

import java.util.Optional;
import car.sharing.dto.request.UserRequestDto;
import car.sharing.entity.User;

public interface UserService extends AbstractService<User> {
    Optional<User> findByEmail(String email);

    User updateUserRole(Long id, String role);

    User updateProfileInfo(String email, UserRequestDto dto);
}
