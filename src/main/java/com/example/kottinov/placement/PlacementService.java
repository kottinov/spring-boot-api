package com.example.kottinov.placement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacementService {

  private final PlacementRepository placementRepository;

  @Autowired
  public PlacementService(PlacementRepository placementRepository) {
    this.placementRepository = placementRepository;
  }

  public List<Placement> getPlacements() {
    return placementRepository.findAll();
  }

  public void addPlacement(Placement placement) {
    placementRepository.save(placement);
  }

  public void deletePlacement(Long id) {
    boolean exists = placementRepository.existsById(id);
    if (!exists) {
      throw new IllegalStateException(
        "Placement with id " + id + " does not exists"
      );
    }
    placementRepository.deleteById(id);
  }

  public void updatePlacement(Placement placement) {
    placementRepository
      .findById(placement.getId())
      .orElseThrow(() ->
        new IllegalStateException(
          "Placement with id " + placement.getId() + " does not exists"
        )
      );
    placementRepository.save(placement);
  }
}
