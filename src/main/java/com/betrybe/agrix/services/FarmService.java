package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service class for managing Farm entities.
 */
public class FarmService {
  private FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public FarmRepository getFarmRepository() {
    return farmRepository;
  }

  public void setFarmRepository(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }
}
