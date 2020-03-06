package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.model.Card;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.ebanq.web.other.Urls.CARDS_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardsPage extends BasePage {
    public static final String ACTIVE_PAGES_PAGE_CSS = "app-cards > .container";
    public static final String CREATE_BTN_CSS = "[routerlink='/admin/accounts/cards/create']";

    @Override
    public CardsPage isPageOpened() {
        $(ACTIVE_PAGES_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public CardsPage openPage() {
        open(CARDS_PAGE);
        return this;
    }

    public void clickCreateNewAccount() {
        $(CREATE_BTN_CSS).click();
    }

    public CardsPage isCardVisibleOnGrid(Card card) {
        isPageOpened();
        String currentCardType = new EbanqTable(card.getUser(), "Card type").get();
        String currentExpirationDate = new EbanqTable(card.getUser(), "Expiration Date").get();
        String currentStatus = new EbanqTable(card.getUser(), "Status").get();
        if(card.getCardType().equals("Mastercard Gold Prepaid")) {
            String currentCardNumber = new EbanqTable(card.getUser(), "Card #").get();
            assertEquals(currentCardNumber, card.getCardNumber());
        }
        assertTrue(currentExpirationDate.contains(card.getExpirationDateMonth()));
        assertTrue(currentExpirationDate.contains(card.getExpirationDateYear()));
        assertEquals(currentCardType, card.getCardType());
        assertEquals(currentStatus, card.getStatus().toLowerCase());
        return this;
    }

    public CardsPage openEditCardPage(Card card) {
        WebElement element = $(String.format("[title='%s']", card.getUser()));
        //There is need use js here because *element* is overlapped by popup
        JavascriptExecutor executor = (JavascriptExecutor)getWebDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }
}