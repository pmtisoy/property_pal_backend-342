package property.pal.bacolod.service;

import org.springframework.stereotype.Service;
import property.pal.bacolod.model.Booking;
import property.pal.bacolod.repository.BookingRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
    }

    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking update(Integer id, Booking booking) {
        if (!bookingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found");
        }
        booking.setBookingId(id);
        return bookingRepository.save(booking);
    }

    public void delete(Integer id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found");
        }
        bookingRepository.deleteById(id);
    }
}
