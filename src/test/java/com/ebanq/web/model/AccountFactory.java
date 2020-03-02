package com.ebanq.web.model;

public class AccountFactory {
    public static Account getAccount(String accountNumber, String accountType, String user, String status, String initialBalance) {
        return Account.builder()
                .accountNumber(accountNumber)
                .accountType(accountType)
                .user(user)
                .status(status)
                .initialBalance(initialBalance)
                .build();
    }
}