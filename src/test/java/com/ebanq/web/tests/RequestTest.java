package com.ebanq.web.tests;

import com.ebanq.web.model.Transfer;
import com.ebanq.web.model.User;
import com.ebanq.web.tests.base.BaseTest;
import org.testng.annotations.Test;
import java.util.HashMap;

public class RequestTest extends BaseTest {
    @Test(description = "Create and approve new transfer between account")
    public void transferBetweenAccountsTest() {
        HashMap<String, String> TransferIds = new HashMap<>();
        Transfer transfer = new Transfer(
                "Transfer Between Accounts",
                "EBQ11223487456",
                "EBQ11113487654",
                "EUR",
                1.11);
        User user = new User(
                "user@ebanq.com",
                "newebanq",
                "ebanqclient");
        //create new transfer as an user
        loginSteps.logIn(user.getEmail(), user.getPassword());
        String requestID = transferUserSteps.openCreateNewTransferRequestPage("Transfer Between Accounts")
                .createNewTransferRequest(transfer);
        loginSteps.logOut();
        //validate the transfer and approve it as an admin
        loginSteps.logIn(testData.ADMIN_USER, testData.ADMIN_PASS);
        requestsSteps.validateRequestOnGridBeforeApprove(transfer, requestID, user)
                .validateRequestDetailsOnRequestPage(transfer,requestID,user);
        TransferIds = requestsSteps.validateRequestWasApproved(transfer);
        requestsSteps.validateRequestOnGridAfterApprove(transfer, requestID, user);
        loginSteps.logOut();
        //validate the transfer as an user
        loginSteps.logIn(user.getEmail(), user.getPassword());
        accountsStepsUser.validateDebitTransferDetails(transfer, TransferIds.get(transfer.getDebitAccountNumber()))
                .validateCreditTransferDetails(transfer, TransferIds.get(transfer.getCreditAccountNumber()));
        reportsUserSteps.validateDebitTransferDetails(transfer, TransferIds.get(transfer.getDebitAccountNumber()))
                .validateCreditTransferDetails(transfer, TransferIds.get(transfer.getCreditAccountNumber()));
    }
}