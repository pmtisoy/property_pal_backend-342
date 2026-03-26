package property.pal.bacolod.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import property.pal.bacolod.model.Guest;
import property.pal.bacolod.service.GuestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> findAll() {
        return guestService.findAll();
    }

    @GetMapping("/{id}")
    public Guest findById(@PathVariable Integer id) {
        return guestService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody Guest guest) {
        Guest saved = guestService.create(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Guest update(@PathVariable Integer id, @RequestBody Guest guest) {
        return guestService.update(id, guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
