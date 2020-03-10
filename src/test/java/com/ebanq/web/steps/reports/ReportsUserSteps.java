package com.ebanq.web.steps.reports;

import com.ebanq.web.model.Transfer;
import com.ebanq.web.pageobjects.reports.ReportsPageUser;
import io.qameta.allure.Step;
import static org.testng.Assert.assertEquals;

public class ReportsUserSteps {
    private ReportsPageUser reportsPageUser;
    private double availableDebitBalance;
    private double updatedAvailableDebitBalance;

    public ReportsUserSteps() {
        reportsPageUser = new ReportsPageUser();
    }

    @Step("Get debit account amount")
    public ReportsUserSteps getAccountAmount(Transfer transfer) {
        reportsPageUser.openPage()
                .isPageOpened()
                .changeAccount(transfer.getDebitAccountNumber());
        availableDebitBalance = Double.parseDouble(reportsPageUser.getAccountBalance());
        return this;
    }

    @Step("Validate the debit balance received is equal to the calculated balance")
    public ReportsUserSteps validateFinalDebitAccountAmount(Transfer transfer) {
        reportsPageUser.openPage()
                .isPageOpened()
                .changeAccount(transfer.getDebitAccountNumber());
        updatedAvailableDebitBalance = Double.parseDouble(reportsPageUser.getAccountBalance());
        double calculatedAvailableDebitBalance = availableDebitBalance - transfer.getTransferAmount();
        assertEquals(updatedAvailableDebitBalance, calculatedAvailableDebitBalance, 0.001);
        return this;
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
