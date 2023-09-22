package car.sharing.service;

import java.util.List;
import car.sharing.entity.Rental;

public interface RentalService extends AbstractService<Rental> {
    List<Rental> getOverdueRentals();

    Rental findActualRental(Long userId);

    List<Rental> getByUserAndStatus(Long userId, Boolean isActive);

    Rental returnRental(Long id);
}
