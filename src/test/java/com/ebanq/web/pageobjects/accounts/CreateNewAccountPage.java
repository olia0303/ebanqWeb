package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqSelect;
import com.ebanq.web.model.Account;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.ebanq.web.other.Urls.CREATE_ACCOUNTS_PAGE;
import com.ebanq.web.elements.EbanqInput;

public class CreateNewAccountPage extends BasePage {
    @Override
    public CreateNewAccountPage isPageOpened() {
        $(By.xpath("//div[contains(text(), 'Create New Account')]")).shouldBe(Condition.visible);
        return this;
    }

    public CreateNewAccountPage openPage() {
        open(CREATE_ACCOUNTS_PAGE);
        return this;
    }

    public CreateNewAccountPage fillRequiredFields(Account account) {
        new EbanqSelect("Account type")
            .selectValue(account.getAccountType());
        new EbanqInput("Account number")
                .write(account.getAccountNumber());
        new EbanqSelect("User")
                .selectValue(account.getUser());
        new EbanqSelect("Status")
                .selectValue(account.getStatus());
        new EbanqInput("Initial Balance")
                .write(account.getInitialBalance());
        return this;
    }

    public void clickCreateButton() {
        $(By.xpath("//button[contains(text(), 'Create')]")).click();
        isSuccessNotificationDisplayed();
    }

    public void isSuccessNotificationDisplayed() {
        $(By.xpath("//*[contains(text(), 'Account has been successfully created')]")).shouldBe(Condition.visible);
    }

    public void isErrorNotificationDisplayed() {
        $(By.xpath("//*[contains(text(), 'There are errors on the form. Please fix them and try submitting again.')]")).shouldBe(Condition.visible);
    }
}