package property.pal.bacolod.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import property.pal.bacolod.model.Building;
import property.pal.bacolod.service.BuildingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public List<Building> findAll() {
        return buildingService.findAll();
    }

    @GetMapping("/{id}")
    public Building findById(@PathVariable Integer id) {
        return buildingService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Building> create(@RequestBody Building building) {
        Building saved = buildingService.create(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Building update(@PathVariable Integer id, @RequestBody Building building) {
        return buildingService.update(id, building);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        buildingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
