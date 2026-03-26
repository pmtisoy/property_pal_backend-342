package property.pal.bacolod.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import property.pal.bacolod.model.BookingStatus;

public class BookingDto {
    public Integer bookingId;
    public Integer unitId;
    public Integer guestId;
    public LocalDate checkInDate;
    public LocalDate checkOutDate;
    public BigDecimal totalPrice;
    public BookingStatus status;
    public LocalDateTime createdAt;
}
