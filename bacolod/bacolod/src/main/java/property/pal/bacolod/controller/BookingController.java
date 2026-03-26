package property.pal.bacolod.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import property.pal.bacolod.model.Booking;
import property.pal.bacolod.service.BookingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import property.pal.bacolod.dto.BookingDto;
import property.pal.bacolod.model.Unit;
import property.pal.bacolod.model.Guest;
import property.pal.bacolod.repository.UnitRepository;
import property.pal.bacolod.repository.GuestRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final UnitRepository unitRepository;
    private final GuestRepository guestRepository;

    public BookingController(BookingService bookingService, UnitRepository unitRepository, GuestRepository guestRepository) {
        this.bookingService = bookingService;
        this.unitRepository = unitRepository;
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public Booking findById(@PathVariable Integer id) {
        return bookingService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingDto bookingDto) {
        Unit unit = unitRepository.findById(bookingDto.unitId).orElseThrow(() -> new RuntimeException("Unit not found"));
        Guest guest = guestRepository.findById(bookingDto.guestId).orElseThrow(() -> new RuntimeException("Guest not found"));

        Booking booking = new Booking();
        booking.setUnit(unit);
        booking.setGuest(guest);
        booking.setCheckInDate(bookingDto.checkInDate);
        booking.setCheckOutDate(bookingDto.checkOutDate);
        booking.setTotalPrice(bookingDto.totalPrice);
        booking.setStatus(bookingDto.status);
        booking.setCreatedAt(bookingDto.createdAt);

        Booking saved = bookingService.create(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Integer id, @RequestBody Booking booking) {
        return bookingService.update(id, booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
