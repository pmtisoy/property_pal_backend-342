package property.pal.bacolod.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import property.pal.bacolod.dto.UnitDto;
import property.pal.bacolod.model.Unit;
import property.pal.bacolod.model.Building;
import property.pal.bacolod.model.User;
import property.pal.bacolod.repository.BuildingRepository;
import property.pal.bacolod.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import property.pal.bacolod.service.UnitService;
import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {
    private final UnitService unitService;
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;

    public UnitController(UnitService unitService, BuildingRepository buildingRepository, UserRepository userRepository) {
        this.unitService = unitService;
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Unit> findAll() {
        return unitService.findAll();
    }

    @GetMapping("/{id}")
    public Unit findById(@PathVariable Integer id) {
        return unitService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Unit> create(@RequestBody UnitDto unitDto) {
        Building building = buildingRepository.findById(unitDto.buildingId)
            .orElseThrow(() -> new RuntimeException("Building not found"));
        User owner = userRepository.findById(unitDto.ownerId)
            .orElseThrow(() -> new RuntimeException("Owner not found"));

        Unit unit = new Unit();
        unit.setBuilding(building);
        unit.setOwner(owner);
        unit.setUnitCode(unitDto.unitCode);
        unit.setTitle(unitDto.title);
        unit.setDescription(unitDto.description);
        unit.setPricePerNight(unitDto.pricePerNight);
        unit.setMaxGuests(unitDto.maxGuests);
        unit.setIsActive(unitDto.isActive);

        Unit saved = unitService.create(unit);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Unit update(@PathVariable Integer id, @RequestBody Unit unit) {
        return unitService.update(id, unit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        unitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
