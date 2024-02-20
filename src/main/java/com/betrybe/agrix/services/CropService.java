package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Service entities.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmRepository farmRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FarmRepository farmRepository) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
  }

  /**
   * createCrop method.
   */
  public Optional<Crop> createCrop(Long farmId, Crop crop) {
    return farmRepository.findById(farmId).map(farm -> {
      crop.setFarm(farm);
      return cropRepository.save(crop);
    });
  }
}
