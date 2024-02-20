package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.ResponseDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for managing Crop entities.
 */
@RestController
@RequestMapping("/farms/{farmId}/crops")
public class CropController {
  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Handles HTTP POST requests to create a new crop.
   */
  @PostMapping
  public ResponseEntity<?> newCrop(@PathVariable Long farmId, @RequestBody Crop newCrop) {
    Optional<Crop> cropOptional = cropService.createCrop(farmId, newCrop);
    if (cropOptional.isEmpty()) {
      ResponseDto<Crop> responseDto = new ResponseDto<>(
          String.format("Fazenda não encontrada!", farmId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }
    CropDto cropDto = new CropDto(
        cropOptional.get().getId(),
        cropOptional.get().getName(),
        cropOptional.get().getPlantedArea(),
        farmId);
    return ResponseEntity.status(HttpStatus.CREATED).body(cropDto);
  }

}