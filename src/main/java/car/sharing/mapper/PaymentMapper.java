package car.sharing.mapper;

import car.sharing.config.mappers.MapperConfig;
import car.sharing.dto.request.PaymentRequestDto;
import car.sharing.dto.response.PaymentResponseDto;
import car.sharing.entity.Payment;
import car.sharing.entity.Rental;
import car.sharing.service.RentalService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public abstract class PaymentMapper {
    private RentalService rentalService;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "rentalId", target = "rental.id")
    public abstract Payment toEntity(PaymentRequestDto dto);

    @Mapping(source = "rental.id", target = "rentalId")
    public abstract PaymentResponseDto toDto(Payment entity);

    @Named("getRentalById")
    protected Rental getRentalById(Long rentalId) {
        return rentalService.getById(rentalId);
    }
}
