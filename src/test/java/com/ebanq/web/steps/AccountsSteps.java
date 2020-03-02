package com.ebanq.web.steps;

import com.ebanq.web.model.Account;
import com.ebanq.web.pageobjects.accounts.AccountsPage;
import com.ebanq.web.pageobjects.accounts.CreateNewAccountPage;
import io.qameta.allure.Step;

public class AccountsSteps {
    private CreateNewAccountPage createNewAccountPage;
    private AccountsPage accountsPage;

    public AccountsSteps() {
        this.createNewAccountPage = new CreateNewAccountPage();
        this.accountsPage = new AccountsPage();
    }

    @Step("Open create new accounts page")
    public AccountsSteps openCreateNewAccountsPage() {
        accountsPage.openPage()
                .clickCreateNewAccount();
        createNewAccountPage.isPageOpened();
        return this;
    }

    @Step("Create a new account with the Account: {account}")
    public AccountsSteps createNewAccount(Account account) {
        createNewAccountPage
                .isPageOpened()
                .fillRequiredFields(account)
                .clickCreateButton();
        return this;
    }

    @Step("Check the account with the Account {account} is displayed on the Account Grid")
    public void accountDetailsInTableShouldBeCorrect(Account account) {
        accountsPage.isPageOpened()
                .isAccountVisibleOnGrid(account);
    }
}
