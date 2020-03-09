package com.ebanq.web.pageobjects.transfers;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqAccountSelect;
import com.ebanq.web.elements.EbanqInput;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class TransferBetweenAccountsPage extends BasePage {
    private final String ACTIVE_TRANSFER_BETWEEN_ACCOUNTS_PAGE_CSS = "app-user-tba > .content";
    private final String ACCOUNT_AMOUNT_XPATH = "//span[contains(text(), '%s')]/parent::div/span[@class='bottom-hint']";
    private final String CONTINUE_BUTTON_XPATH = "//*[contains(text(), 'Continue')]";
    private final String CONFIRM_BUTTON_XPATH = "//*[contains(text(), 'Confirm')]";

    @Override
    public TransferBetweenAccountsPage isPageOpened() {
        $(ACTIVE_TRANSFER_BETWEEN_ACCOUNTS_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public TransferBetweenAccountsPage fillRequiredFields(String debitFromAccountNumber, String creditToAccountNumber, double transferAmount) {
        new EbanqInput("Amount to transfer *")
                .write(transferAmount);
        new EbanqAccountSelect("Debit from")
                .selectValue(debitFromAccountNumber);
        new EbanqAccountSelect("Credit to")
                .selectValue(creditToAccountNumber);
        return this;
    }

    private String getAccountAmountInfo(String accountNumber) {
        return $(By.xpath(String.format(ACCOUNT_AMOUNT_XPATH, accountNumber))).getText();
    }

    public String getAccountAmount(String accountNumber) {
        return getAccountAmountInfo(accountNumber).replaceAll("[^\\,-\\.\\d]", "");
    }

    public String getAccountCurrency(String accountNumber) {
        return getAccountAmountInfo(accountNumber).replaceAll("[^\\s]", "");
    }

    public TransferBetweenAccountsPage clickContinueButton() {
        $(By.xpath(CONTINUE_BUTTON_XPATH)).click();
        return this;
    }

    public TransferBetweenAccountsPage clickConfirmButton() {
        $(By.xpath(CONFIRM_BUTTON_XPATH)).click();
        return this;
    }
}