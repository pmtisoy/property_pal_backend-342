package property.pal.bacolod.service;

import org.springframework.stereotype.Service;
import property.pal.bacolod.model.Guest;
import property.pal.bacolod.repository.GuestRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(Integer id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found"));
    }

    public Guest create(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest update(Integer id, Guest guest) {
        if (!guestRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found");
        }
        guest.setUserId(id);
        return guestRepository.save(guest);
    }

    public void delete(Integer id) {
        if (!guestRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found");
        }
        guestRepository.deleteById(id);
    }
}
