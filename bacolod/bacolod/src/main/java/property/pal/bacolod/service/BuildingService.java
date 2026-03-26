package property.pal.bacolod.service;

import org.springframework.stereotype.Service;
import property.pal.bacolod.model.Building;
import property.pal.bacolod.repository.BuildingRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public Building findById(Integer id) {
        return buildingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Building not found"));
    }

    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    public Building update(Integer id, Building building) {
        if (!buildingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Building not found");
        }
        building.setBuildingId(id);
        return buildingRepository.save(building);
    }

    public void delete(Integer id) {
        if (!buildingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Building not found");
        }
        buildingRepository.deleteById(id);
    }
}
