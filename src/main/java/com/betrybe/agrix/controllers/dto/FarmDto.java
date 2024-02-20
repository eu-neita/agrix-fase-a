package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Farm;

public record FarmDto(Long id, String name, int size) {
  public Farm toFarm() {
    return new Farm(id, name, size);
  }
}
