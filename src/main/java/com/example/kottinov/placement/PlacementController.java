package com.example.kottinov.placement;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

  private final PlacementService placementService;

  @Autowired
  public PlacementController(PlacementService placementService) {
    this.placementService = placementService;
  }

  @GetMapping("/")
  public List<PlacementDTO> getPlacements() {
    return placementService
      .getPlacements()
      .stream()
      .map(this::convertToDTO)
      .collect(Collectors.toList());
  }

  @PostMapping("/")
  public void addPlacement(@RequestBody Placement placement) {
    placementService.addPlacement(placement);
  }

  @DeleteMapping("/{placementId}")
  public void deletePlacement(@PathVariable("placementId") Long placementId) {
    placementService.deletePlacement(placementId);
  }

  private PlacementDTO convertToDTO(Placement placement) {
    PlacementDTO placementDTO = new PlacementDTO();
    placementDTO.setId(placement.getId());
    placementDTO.setCustomer(placement.getCustomer());
    placementDTO.setProducts(placement.getProducts());

    return placementDTO;
  }
}
