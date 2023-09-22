package car.sharing.service;

import car.sharing.entity.Payment;
import car.sharing.entity.User;

public interface PaymentService extends AbstractService<Payment> {
    Payment getByUser(User user);

    Payment findBySessionId(String sessionId);
}
