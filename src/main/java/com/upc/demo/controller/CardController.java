package com.upc.demo.controller;

import com.upc.demo.domain.model.Card;
import com.upc.demo.domain.service.CardService;
import com.upc.demo.resource.CardResource;
import com.upc.demo.resource.saving.SaveCardResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CardService cardService;
    @GetMapping("/users/{userId}/cards")
    public List<CardResource> getAllCardsByUserId(
            @PathVariable(name = "userId") Long userId) {

        return cardService.getAllCardsByUserId(userId).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/users/{userId}/cards/{cardId}")
    public CardResource getCardByIdAndUserId(@PathVariable(name = "userId") Long userId,
                                                   @PathVariable(name = "cardId") Long cardId) {
        return convertToResource(cardService.getCardByIdAndUserId(userId, cardId));
    }

    @PostMapping("/users/{userId}/cards")
    public CardResource createCard(@PathVariable(name = "userId") Long userId,
                                   @Valid @RequestBody SaveCardResource resource) {
        return convertToResource(cardService.createCard(userId, convertToEntity(resource)));

    }

    @PutMapping("/users/{userId}/cards/{cardId}")
    public CardResource updateCard(@PathVariable(name = "userId") Long userId,
                                         @PathVariable(name = "cardId") Long cardId,
                                         @Valid @RequestBody SaveCardResource resource) {
        return convertToResource(cardService.updateCard(userId, cardId, convertToEntity(resource)));
    }

    @DeleteMapping("/users/{userId}/cards/{cardId}")
    public ResponseEntity<?> deleteCard(@PathVariable(name = "userId") Long userId,
                                           @PathVariable(name = "cardId") Long cardId) {
        return cardService.deleteCard(userId, cardId);
    }

    private Card convertToEntity(SaveCardResource resource) {
        return mapper.map(resource, Card.class);
    }

    private CardResource convertToResource(Card entity) {
        return mapper.map(entity, CardResource.class);
    }


}
