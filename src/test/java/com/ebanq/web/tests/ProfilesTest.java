package com.ebanq.web.tests;

import com.ebanq.web.model.Administrator;
import com.ebanq.web.model.AdministratorFactory;
import com.ebanq.web.other.TestData;
import com.ebanq.web.steps.profiles.ProfilesSteps;
import com.ebanq.web.tests.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfilesTest extends BaseTest {
    private ProfilesSteps profilesSteps;

    @BeforeClass
    public void setupSteps() {
        profilesSteps = new ProfilesSteps();
    }
    
    @Test(description = "Creation of Administrator")
    public void createAdministratorProfilesTest() {
        loginSteps.logIn(new TestData().ADMIN_USER, new TestData().ADMIN_PASS);
        Administrator administrator = AdministratorFactory.getAdministrator("Personal");
        profilesSteps.openAdministratorProfiles()
                     .createAdministrator(administrator);
        loginSteps.logOut();
    }
}