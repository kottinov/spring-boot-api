package com.example.kottinov.placement;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Long> {
  @Query("SELECT u FROM Placement u WHERE u.id = ?1")
  Optional<Placement> findPlacementById(Long id);
}
