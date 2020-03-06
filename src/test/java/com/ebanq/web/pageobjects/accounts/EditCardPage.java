package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.model.Card;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditCardPage extends BasePage {
    public static final String ACTIVE_EDIT_CARD_PAGE_CSS = "app-view-edit-card > .filter-container";

    @Override
    public EditCardPage isPageOpened() {
        $(ACTIVE_EDIT_CARD_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public EditCardPage validateCardDetails(Card card) {
        String currentUsername = getCurrentInfo("Username");
        String currentExpirationDate = getCurrentInfo("Expiration date");
        String currentStatus = getCurrentInfo("Status");
        String currentCardType = getCurrentInfo("Card Type");
        if(card.getCardType().equals("Mastercard Gold Prepaid")) {
            String currentCardNumber = getPageName();
            assertTrue(currentCardNumber.contains(card.getCardNumber()));
        }
        assertEquals(currentUsername, card.getUser());
        assertTrue(currentExpirationDate.contains(card.getExpirationDateMonth()));
        assertTrue(currentExpirationDate.contains(card.getExpirationDateYear()));
        assertEquals(currentStatus, card.getStatus());
        assertEquals(currentCardType, card.getCardType());
        return this;
    }

    private String getCurrentInfo(String text) {
        return $(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div/*[contains(@class, 'clip')]", text))).getText();
    }

    private String getPageName() {
        return $("app-view-edit-card .page-name").getText();
    }
}