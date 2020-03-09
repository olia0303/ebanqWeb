package com.ebanq.web.steps.requests;

import com.ebanq.web.model.Transfer;
import com.ebanq.web.model.User;
import com.ebanq.web.pageobjects.requests.RequestPage;
import com.ebanq.web.pageobjects.requests.TransferRequestDetailsPage;
import io.qameta.allure.Step;
import java.util.HashMap;

public class RequestsSteps {
    private RequestPage requestPage;
    private TransferRequestDetailsPage transferRequestDetailsPage;

    public RequestsSteps() {
        this.requestPage = new RequestPage();
        this.transferRequestDetailsPage = new TransferRequestDetailsPage();
    }

    @Step("Validate transfer request details {transfer} are correct on the Requests Grid before request has been approved")
    public RequestsSteps validateRequestOnGridBeforeApprove(Transfer transfer, String requestID, User user) {
        requestPage.isPageOpened()
                .isRequestExist(requestID)
                .validateRequestDetails(transfer, requestID, user.getName())
                .validateRequestStatus(requestID,"Pending");
        return this;
    }

    @Step("Validate transfer request details {transfer} are correct on the Request Details Page")
    public RequestsSteps validateRequestDetailsOnRequestPage(Transfer transfer, String requestID, User user) {
        requestPage.openTransferRequestDetailsPage(requestID);
        transferRequestDetailsPage.isPageOpened()
                .validateTransferRequestDetails(transfer, user.getName())
                .validateStatus(transfer,"Pending");
        return this;
    }

    @Step("Request was approved, success notification was displayed and status was changed")
    public HashMap<String, String> validateRequestWasApproved(Transfer transfer) {
        HashMap<String, String> ids = new HashMap<>();
        transferRequestDetailsPage.isPageOpened()
                .clickExecuteButton()
                .isSuccessNotificationDisplayed()
                .validateStatus(transfer, "Executed");
        ids.put(transfer.getCreditAccountNumber(), transferRequestDetailsPage.getCreditID(transfer));
        ids.put(transfer.getDebitAccountNumber(), transferRequestDetailsPage.getDebitID(transfer));
        return ids;
    }

    @Step("Validate transfer request details {transfer} are correct on the Requests Grid after request has been approved")
    public RequestsSteps validateRequestOnGridAfterApprove(Transfer transfer, String requestID, User user) {
        requestPage.openPage()
                .isPageOpened()
                .validateRequestDetails(transfer, requestID, user.getName())
                .validateRequestStatus(requestID, "Executed");
        return this;
    }
}