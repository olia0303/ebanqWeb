package com.ebanq.web.pageobjects.requests;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.elements.EbanqText;
import com.ebanq.web.model.Transfer;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TransferRequestDetailsPage extends BasePage {
    private final String ACTIVE_TRANSFER_REQUEST_DETAILS_PAGE_CSS = "app-view-request .container";
    private final String EXECUTE_BUTTON_CSS = ".def-btn-success";
    private final String SUCCESS_MESSAGE_XPATH = "//*[contains(text(), 'Transfer request has been successfully executed')]";

    @Override
    public TransferRequestDetailsPage isPageOpened() {
        $(ACTIVE_TRANSFER_REQUEST_DETAILS_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public TransferRequestDetailsPage clickExecuteButton() {
        $(EXECUTE_BUTTON_CSS).click();
        isSuccessNotificationDisplayed();
        return this;
    }

    public TransferRequestDetailsPage validateTransferRequestDetails(Transfer transfer, String name) {
        validateSystemRequestDetails(transfer, name);
        validateTransferDetails(transfer);
        validateTable(transfer);
        return this;
    }

    public TransferRequestDetailsPage validateStatus(Transfer transfer, String status) {
        (new WebDriverWait(getWebDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                String currentDebitStatus = new EbanqTable(transfer.getDebitAccountNumber()).get("Status");
                String currentCreditStatus = new EbanqTable(transfer.getCreditAccountNumber()).get("Status");
                String currentStatus = new EbanqText("Status").get();
                return currentDebitStatus.equals(status) && currentCreditStatus.equals(status) && currentStatus.equals(status);
            }
        });
        return this;
    }

    public String getDebitID(Transfer transfer) {
        return new EbanqTable(transfer.getDebitAccountNumber()).get("ID");
    }

    public String getCreditID(Transfer transfer) {
        return new EbanqTable(transfer.getCreditAccountNumber()).get("ID");
    }

    public TransferRequestDetailsPage isSuccessNotificationDisplayed() {
        $(By.xpath(SUCCESS_MESSAGE_XPATH)).shouldBe(Condition.visible);
        return this;
    }

    private void validateSystemRequestDetails(Transfer transfer, String name) {
        String currentUsername = new EbanqText("Username").get();
        String currentSubject = new EbanqText("Subject").get();
        assertEquals(currentUsername, name);
        assertEquals(currentSubject, transfer.getTransferSubject());
    }

    private void validateTransferDetails(Transfer transfer) {
        String currentTransferAmount = new EbanqText("Amount").get().replaceAll("[^.\\d]","");
        assertEquals(currentTransferAmount, String.valueOf(transfer.getTransferAmount()));
    }

    private TransferRequestDetailsPage validateTable(Transfer transfer) {
        HashMap<String, String> debitRow = new HashMap<>();
        HashMap<String, String> creditRow = new HashMap<>();
        debitRow = new EbanqTable(transfer.getDebitAccountNumber()).getRow();
        creditRow = new EbanqTable(transfer.getCreditAccountNumber()).getRow();
        assertTrue(debitRow.get("Description").contains(transfer.getCreditAccountNumber()));
        assertEquals(debitRow.get("Currency"), transfer.getTransferCurrency());
        assertEquals(debitRow.get("Debit/Credit"), "-" + String.valueOf(transfer.getTransferAmount()));
        assertTrue(creditRow.get("Description").contains(transfer.getDebitAccountNumber()));
        assertEquals(creditRow.get("Currency"), transfer.getTransferCurrency());
        assertEquals(creditRow.get("Debit/Credit"), String.valueOf(transfer.getTransferAmount()));
        return this;
    }
}