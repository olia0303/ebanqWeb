package com.ebanq.web.model;

public class CardFactory {
    public static Card getCard(String user, String cardType, String cardNumber, String expirationDateMonth, String expirationDateYear, String status) {
        return Card.builder()
                .user(user)
                .cardType(cardType)
                .cardNumber(cardNumber)
                .expirationDateMonth(expirationDateMonth)
                .expirationDateYear(expirationDateYear)
                .status(status)
                .build();
    }
}