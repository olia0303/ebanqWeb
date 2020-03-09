package com.ebanq.web.pageobjects.requests;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.model.Transfer;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.ebanq.web.other.Urls.REQUESTS_PAGE;
import static org.testng.Assert.assertEquals;

public class RequestPage extends BasePage {
    private final String ACTIVE_REQUEST_PAGE_CSS = "[data-title='Amount']";
    private final String REQUEST_ID_CELL_XPATH = "//td[text() = '%s']";

    @Override
    public RequestPage isPageOpened() {
        $(ACTIVE_REQUEST_PAGE_CSS).shouldBe(Condition.visible).shouldNot(Condition.empty);
        return this;
    }

    public RequestPage openPage() {
        open(REQUESTS_PAGE);
        return this;
    }

    public RequestPage openTransferRequestDetailsPage(String requestID) {
        WebElement element = $(By.xpath(String.format(REQUEST_ID_CELL_XPATH, requestID)));
        //There is need use js here because *element* is overlapped by popup
        JavascriptExecutor executor = (JavascriptExecutor)getWebDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public RequestPage isRequestExist(String requestID) {
        $(By.xpath(String.format(REQUEST_ID_CELL_XPATH, requestID))).shouldBe(Condition.visible);
        return this;
    }

    public RequestPage validateRequestDetails(Transfer transfer, String requestID, String name) {
        HashMap<String, String> row = new HashMap<>();
        isPageOpened();
        row = new EbanqTable(requestID).getRow();
        String currentName = row.get("Name");
        String currentAmount = row.get("Amount");
        String currentSubject = row.get("Subject");
        String currentCurrency = row.get("Currency");
        assertEquals(currentName, name);
        assertEquals(currentSubject, transfer.getTransferSubject());
        assertEquals(currentAmount, String.valueOf(transfer.getTransferAmount()));
        assertEquals(currentCurrency, transfer.getTransferCurrency());
        return this;
    }

    public RequestPage validateRequestStatus(String requestID, String status) {
        String currentStatus = new EbanqTable(requestID).get("Status");
        assertEquals(currentStatus, status);
        return this;
    }
}