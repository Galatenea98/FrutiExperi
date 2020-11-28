package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardService {
    List<Card> getAllCardsByUserId(Long userId);
    Card getCardByIdAndUserId(Long userId, Long cardId);
    Card createCard(Long userId, Card card);
    Card updateCard(Long userId, Long cardId, Card cardDetails);
    ResponseEntity<?> deleteCard(Long userId, Long cardId);
}
