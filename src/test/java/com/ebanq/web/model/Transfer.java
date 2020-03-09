package com.ebanq.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transfer {
    public String transferSubject;
    public String debitAccountNumber;
    public String creditAccountNumber;
    public String transferCurrency;
    public double transferAmount;
}