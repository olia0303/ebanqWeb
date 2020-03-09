package com.ebanq.web.steps.accounts;

import com.ebanq.web.model.Account;
import com.ebanq.web.pageobjects.accounts.AccountsPage;
import com.ebanq.web.pageobjects.accounts.CreateNewAccountPage;
import com.ebanq.web.pageobjects.accounts.EditAccountPage;
import io.qameta.allure.Step;

public class AccountsSteps {
    private CreateNewAccountPage createNewAccountPage;
    private AccountsPage accountsPage;
    private EditAccountPage editAccountPage;

    public AccountsSteps() {
        this.createNewAccountPage = new CreateNewAccountPage();
        this.accountsPage = new AccountsPage();
        this.editAccountPage = new EditAccountPage();
    }

    @Step("Open create new accounts page")
    public AccountsSteps openCreateNewAccountsPage() {
        accountsPage.openPage()
                .clickCreateNewAccount();
        createNewAccountPage.isPageOpened();
        return this;
    }

    @Step("Create a new account: {account}")
    public AccountsSteps createNewAccount(Account account) {
        createNewAccountPage
                .isPageOpened()
                .fillRequiredFields(account)
                .clickCreateButton();
        return this;
    }

    @Step("Check the account {account} is displayed on the Account Grid")
    public AccountsSteps accountDetailsInTableShouldBeCorrect(Account account) {
        accountsPage.isPageOpened()
                .isAccountVisibleOnGrid(account);
        return this;
    }

    @Step("Check the account details {account} is correct on the Edit Account Page")
    public AccountsSteps accountDetailsInAccountEditPageShouldBeCorrect(Account account) {
        accountsPage.isPageOpened()
                .openEditAccountPage(account);
        editAccountPage.isPageOpened()
                .validateAccountDetails(account);
        return this;
    }
}