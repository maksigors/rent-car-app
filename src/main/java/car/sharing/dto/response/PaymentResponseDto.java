package car.sharing.dto.response;

import java.math.BigDecimal;
import lombok.Data;
import car.sharing.entity.Payment;

@Data
public class PaymentResponseDto {
    private Payment.PaymentStatus status;
    private Payment.PaymentType type;
    private Long rentalId;
    private String sessionUrl;
    private String sessionId;
    private BigDecimal amountToPay;
}
