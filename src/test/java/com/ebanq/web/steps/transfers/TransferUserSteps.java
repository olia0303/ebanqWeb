package com.ebanq.web.steps.transfers;

import com.ebanq.web.model.Transfer;
import com.ebanq.web.pageobjects.transfers.TransferBetweenAccountsPage;
import com.ebanq.web.pageobjects.transfers.TransfersPage;
import io.qameta.allure.Step;
import java.util.HashMap;

public class TransferUserSteps {
    private TransfersPage transfersPage;
    private TransferBetweenAccountsPage transferBetweenAccountsPage;

    public TransferUserSteps() {
        transfersPage = new TransfersPage();
        transferBetweenAccountsPage = new TransferBetweenAccountsPage();
    }

    @Step("Open transfer page: {transferType}")
    public TransferUserSteps openCreateNewTransferRequestPage(String transferType) {
        transfersPage.openPage()
                .isPageOpened()
                .openCreateNewTransferRequestPage(transferType);
        return this;
    }

    @Step("Create new transfer request: {transfer}")
    public String createNewTransferRequest(Transfer transfer) {
        transferBetweenAccountsPage.isPageOpened()
                .fillRequiredFields(transfer.getDebitAccountNumber(), transfer.getCreditAccountNumber(), transfer.getTransferAmount())
                .clickContinueButton()
                .clickConfirmButton();
        String requestID = transfersPage.isSuccessMessageVisible();
        return requestID;
    }
}