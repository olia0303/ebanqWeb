package com.ebanq.web.steps.accounts;

import com.ebanq.web.model.Transfer;
import com.ebanq.web.pageobjects.accounts.AccountsPageUser;
import io.qameta.allure.Step;

public class AccountsStepsUser {
    private AccountsPageUser accountsPageUser;
    public AccountsStepsUser() {
        accountsPageUser = new AccountsPageUser();
    }

    @Step("Validate debit transfer details are correct on Accounts Page on the user side")
    public AccountsStepsUser validateDebitTransferDetails(Transfer transfer, String transferID) {
        accountsPageUser.openPage()
                .isPageOpened()
                .changeAccount(transfer.getDebitAccountNumber())
                .validateTransferDetails(transferID,transfer.getCreditAccountNumber(), "-" + String.valueOf(transfer.getTransferAmount()));
        return this;
    }

    @Step("Validate credit transfer details are correct on Accounts Page on the user side")
    public AccountsStepsUser validateCreditTransferDetails(Transfer transfer, String transferID) {
        accountsPageUser.isPageOpened()
                .changeAccount(transfer.getCreditAccountNumber())
                .validateTransferDetails(transferID,transfer.getDebitAccountNumber(), String.valueOf(transfer.getTransferAmount()));
        return this;
    }
}