package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DirectionService {
    ResponseEntity<?> deleteDirection(Long directionId);
    Direction updateDirection(Long directionId, Direction directionRequest);
    Direction createDirection(Direction direction);
    Direction getDirectionById(Long directionId);

}
