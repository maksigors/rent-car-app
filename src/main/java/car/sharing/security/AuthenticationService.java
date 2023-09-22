package car.sharing.security;

import car.sharing.entity.User;
import car.sharing.exception.AuthenticationException;

public interface AuthenticationService {
    User register(User user);

    User login(String login, String password) throws AuthenticationException;
}
