package property.pal.bacolod.service;

import org.springframework.stereotype.Service;
import property.pal.bacolod.model.Unit;
import property.pal.bacolod.repository.UnitRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    public Unit findById(Integer id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit not found"));
    }

    public Unit create(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit update(Integer id, Unit unit) {
        if (!unitRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit not found");
        }
        unit.setUnitId(id);
        return unitRepository.save(unit);
    }

    public void delete(Integer id) {
        if (!unitRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unit not found");
        }
        unitRepository.deleteById(id);
    }
}
