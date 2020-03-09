package com.ebanq.web.steps.reports;

import com.ebanq.web.model.Transfer;
import com.ebanq.web.pageobjects.reports.ReportsPageUser;
import io.qameta.allure.Step;

public class ReportsUserSteps {
    private ReportsPageUser reportsPageUser;

    public ReportsUserSteps() {
        reportsPageUser = new ReportsPageUser();
    }

    @Step("Validate debit transfer details are correct on Reports Page on the user side")
    public ReportsUserSteps validateDebitTransferDetails(Transfer transfer, String transferID) {
        reportsPageUser.openPage()
                .isPageOpened()
                .changeAccount(transfer.getDebitAccountNumber())
                .validateTransferDetails(transferID,transfer.getCreditAccountNumber(), "-" + String.valueOf(transfer.getTransferAmount()));
        return this;
    }

    @Step("Validate credit transfer details are correct on Reports Page on the user side")
    public ReportsUserSteps validateCreditTransferDetails(Transfer transfer, String transferID) {
        reportsPageUser.isPageOpened()
                .changeAccount(transfer.getCreditAccountNumber())
                .validateTransferDetails(transferID,transfer.getDebitAccountNumber(), String.valueOf(transfer.getTransferAmount()));
        return this;
    }
}
