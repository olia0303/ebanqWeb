package com.ebanq.web.pageobjects.transfers;

import com.codeborne.selenide.Condition;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.ebanq.web.other.Urls.TRANSFER_PAGE;

public class TransfersPage extends BasePage {
    private final String ACTIVE_TRANSFER_PAGE_CSS = "app-transfer > .content";
    private final String REQUEST_TYPE_XPATH = "//*[contains(text(), '%s')]";
    private final String SUCCESS_MESSAGE_CSS = ".success-popup";
    private final String REQUEST_ID_XPATH = "//*[contains(text(), 'Your request has been sent for approval.')]";
    @Override
    public TransfersPage isPageOpened() {
        $(ACTIVE_TRANSFER_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public TransfersPage openPage() {
        open(TRANSFER_PAGE);
        return this;
    }

    public TransfersPage openCreateNewTransferRequestPage(String requestType) {
        $(By.xpath(String.format(REQUEST_TYPE_XPATH, requestType))).click();
        return this;
    }

    public String isSuccessMessageVisible() {
        $(SUCCESS_MESSAGE_CSS).shouldBe(Condition.visible);
        String requestID = $(By.xpath(REQUEST_ID_XPATH)).getText().replaceAll("[^\\d]", "");
        return requestID;
    }
}