package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;

/**
 * Data Transfer Object (DTO) representing Crop data.
 * This record class provides a convenient way to transfer crop data.
 */
public record CropDto(Long id, String name, double plantedArea, Long farmId) {
  public Crop toCrop(FarmRepository farmRepository) {
    Farm farm = farmRepository.findById(farmId).orElse(null);
    return new Crop(id, name, plantedArea, farm);
  }
}