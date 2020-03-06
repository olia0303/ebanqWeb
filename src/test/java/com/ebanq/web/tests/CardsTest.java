package com.ebanq.web.tests;

import com.ebanq.web.model.Card;
import com.ebanq.web.model.CardFactory;
import com.ebanq.web.tests.base.BaseTest;
import org.testng.annotations.Test;

public class CardsTest extends BaseTest {
    @Test(description = "New numeric card creation")
    public void createNewNumericCardTest() {
        Card card = CardFactory.getCard("mvojnovi", "MyChoice Credit Card", "4200000000000001", "May", "2030", "Active");
        loginSteps.logIn(testData.ADMIN_USER, testData.ADMIN_PASS);
        cardsSteps.openCreateNewCardPage()
                .createNewCard(card)
                .cardDetailsInTableShouldBeCorrect(card)
                .cardDetailsInCardEditPageShouldBeCorrect(card);
    }

    @Test(description = "New alphanumeric card creation")
    public void createNewAlphanumericCardTest() {
        Card card = CardFactory.getCard("mvojnovi", "Mastercard Gold Prepaid", "RET5667777777", "May", "2030", "Active");
        loginSteps.logIn(testData.ADMIN_USER, testData.ADMIN_PASS);
        cardsSteps.openCreateNewCardPage()
                .createNewCard(card)
                .cardDetailsInTableShouldBeCorrect(card)
                .cardDetailsInCardEditPageShouldBeCorrect(card);
    }
}