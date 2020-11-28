package com.upc.demo.service;

import com.upc.demo.domain.model.Card;
import com.upc.demo.domain.repository.CardRepository;
import com.upc.demo.domain.repository.UserRepository;
import com.upc.demo.domain.service.CardService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Card> getAllCardsByUserId(Long userId) {
        return cardRepository.findByUserId(userId);
    }

    @Override
    public Card getCardByIdAndUserId(Long userId, Long cardId) {
        return cardRepository.findByIdAndUserId(cardId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Card not found with Id " + cardId +
                                " and UserId " + userId));
    }

    @Override
    public Card createCard(Long userId, Card card) {
        return userRepository.findById(userId).map(user -> {
            card.setUser(user);
            return cardRepository.save(card);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }

    @Override
    public Card updateCard(Long userId, Long cardId, Card cardDetails) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);

        return cardRepository.findById(cardId).map(card -> {
            //card.setText(cardDetails.getText());
            return cardRepository.save(card);
        }).orElseThrow(() -> new ResourceNotFoundException("Card", "Id", cardId));
    }

    @Override
    public ResponseEntity<?> deleteCard(Long userId, Long cardId) {
        return cardRepository.findByIdAndUserId(cardId, userId).map(card -> {
            cardRepository.delete(card);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Card not found with Id " + cardId + " and UserId " + userId));
    }
}
