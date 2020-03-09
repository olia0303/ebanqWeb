package com.ebanq.web.steps.cards;

import com.ebanq.web.model.Card;
import com.ebanq.web.pageobjects.accounts.*;
import io.qameta.allure.Step;

public class CardsSteps {
    private CreateNewCardPage createNewCardPage;
    private CardsPage cardsPage;
    private EditCardPage editCardPage;

    public CardsSteps() {
        this.createNewCardPage = new CreateNewCardPage();
        this.cardsPage = new CardsPage();
        this.editCardPage = new EditCardPage();
    }

    @Step("Open create new card page")
    public CardsSteps openCreateNewCardPage() {
        cardsPage.openPage()
                .clickCreateNewAccount();
        createNewCardPage.isPageOpened();
        return this;
    }

    @Step("Create a new card: {card}")
    public CardsSteps createNewCard(Card card) {
        createNewCardPage
                .isPageOpened()
                .fillRequiredFields(card)
                .clickSaveButton();
        return this;
    }

    @Step("Check the card {card} is displayed on the Card Grid")
    public CardsSteps cardDetailsInTableShouldBeCorrect(Card card) {
        cardsPage.isPageOpened()
                .isCardVisibleOnGrid(card);
        return this;
    }

    @Step("Check the card details {card} is correct on the Edit Card Page")
    public CardsSteps cardDetailsInCardEditPageShouldBeCorrect(Card card) {
        cardsPage.isPageOpened()
                .openEditCardPage(card);
        editCardPage.isPageOpened()
                .validateCardDetails(card);
        return this;
    }
}