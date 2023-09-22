package car.sharing.security;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import car.sharing.entity.User;
import car.sharing.exception.AuthenticationException;
import car.sharing.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public User register(User user) {
        user.setRole(User.Role.CUSTOMER);
        return userService.add(user);
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(login);
        if (user.isEmpty() || !encoder.matches(password, user.get().getPassword())) {
            throw new AuthenticationException("Incorrect username or password.");
        }
        return user.get();
    }
}
