package com.ebanq.web.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Card {
    public String user;
    public String cardType;
    public String cardNumber;
    public String status;
    public String expirationDateMonth;
    public String expirationDateYear;
}
