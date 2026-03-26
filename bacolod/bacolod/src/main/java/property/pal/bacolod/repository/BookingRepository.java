package property.pal.bacolod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import property.pal.bacolod.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
