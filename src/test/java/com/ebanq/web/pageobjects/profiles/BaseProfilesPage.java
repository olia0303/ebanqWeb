package com.ebanq.web.pageobjects.profiles;

import com.codeborne.selenide.Condition;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.ebanq.web.other.Urls.*;

public class BaseProfilesPage extends BasePage {
    
    public static final String CREATE_BTN_CSS = ".plus";
    public static final String CREATE_PROFILE_BUTTON_CSS = ".def-btn-success";
    public static final String PAGE_HEADER_CSS = ".page-name";
   
    @Override
    public BaseProfilesPage isPageOpened() {
        $(ACTIVE_PAGE_CSS).waitUntil(Condition.visible, 30000);
        return this;
    }
    
    public BaseProfilesPage openAdministratorProfiles() {
        open(ADMIN_PROFILES_PAGE);
        isPageOpened();
        return this;
    }
    
    public BaseProfilesPage clickCreateNew() {
        $(CREATE_BTN_CSS).click();
        return this;
    }
    
    public BaseProfilesPage clickCreateProfile() {
        $(CREATE_PROFILE_BUTTON_CSS).click();
        return this;
    }
}
