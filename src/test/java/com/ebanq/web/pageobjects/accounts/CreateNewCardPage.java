package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqInput;
import com.ebanq.web.elements.EbanqSelect;
import com.ebanq.web.model.Card;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.ebanq.web.other.Urls.CREATE_CARDS_PAGE;

public class CreateNewCardPage extends BasePage {
    @Override
    public CreateNewCardPage isPageOpened() {
        $(By.xpath("//div[contains(text(), 'Create New Card')]")).shouldBe(Condition.visible);
        return this;
    }

    public CreateNewCardPage openPage() {
        open(CREATE_CARDS_PAGE);
        return this;
    }

    public CreateNewCardPage fillRequiredFields(Card card) {
        new EbanqSelect("User")
                .selectValue(card.getUser());
        new EbanqSelect("Type")
                .selectValue(card.getCardType());
        new EbanqInput("Number")
                .write(card.getCardNumber());
        new EbanqSelect("Status")
                .selectValue(card.getStatus());
        new EbanqSelect("Expiration date")
                .selectValue(card.getExpirationDateMonth());
        new EbanqInput("Expiration date")
                .write(card.getExpirationDateYear());
        return this;
    }

    public void clickSaveButton() {
        $(By.xpath("//button[contains(text(), 'Save')]")).click();
        isSuccessNotificationDisplayed();
    }

    public void isSuccessNotificationDisplayed() {
        $(By.xpath("//*[contains(text(), 'Card has been successfully created')]")).shouldBe(Condition.visible);
    }
}