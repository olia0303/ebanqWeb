package com.ebanq.web.steps.profiles;

import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.model.Administrator;
import com.ebanq.web.pageobjects.profiles.AdministratorProfilesPage;
import com.ebanq.web.pageobjects.profiles.CreateAdministratorProfilePage;
import com.ebanq.web.pageobjects.profiles.BaseProfilesPage;
import io.qameta.allure.Step;

public class ProfilesSteps {
    public CreateAdministratorProfilePage administratorCreationPage;
    public BaseProfilesPage baseProfilesPage;
    public AdministratorProfilesPage administratorProfilesPage;
    
    public ProfilesSteps() {
        administratorCreationPage = new CreateAdministratorProfilePage();
        baseProfilesPage = new BaseProfilesPage();
        administratorProfilesPage = new AdministratorProfilesPage();
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

    @Step("Open Administrator Details Page")
    public ProfilesSteps openAdministratorSummaryDetails(Administrator administrator)  {
        baseProfilesPage.openAdministratorProfiles();
        administratorProfilesPage.openDetailsPage("Username", administrator.getUserName());
        administratorProfilesPage.isPageOpened();
        return this;
    }
    
    @Step("Validate Administrator Information")
    public ProfilesSteps validateAdministratorDetails(Administrator administrator) {
        administratorProfilesPage.validateDetails(administrator);
        return this;
    }
}