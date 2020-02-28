package com.ebanq.web.steps.profiles;

import com.ebanq.web.model.Administrator;
import com.ebanq.web.pageobjects.profiles.CreateAdministratorProfilePage;
import com.ebanq.web.pageobjects.profiles.BaseProfilesPage;
import io.qameta.allure.Step;

public class ProfilesSteps {
    public CreateAdministratorProfilePage administratorCreationPage;
    public BaseProfilesPage baseProfilesPage;
    
    public ProfilesSteps() {
        administratorCreationPage = new CreateAdministratorProfilePage();
        baseProfilesPage = new BaseProfilesPage();
    }
    
    @Step("Open Administrator Profiles")
    public ProfilesSteps openAdministratorProfiles() {
        baseProfilesPage.openAdministratorProfiles();
        baseProfilesPage.clickCreateNew();
        administratorCreationPage.isPageOpened();
        return this;
    }
    
    @Step("Create New administrator")
    public ProfilesSteps createAdministrator(Administrator administrator)  {
        administratorCreationPage.isPageOpened();
        administratorCreationPage.fillInRequiredFields(administrator);
        administratorCreationPage.clickCreateProfile();
        return this;
    }
}
