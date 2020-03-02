package com.ebanq.web.tests;

import com.ebanq.web.tests.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(description = "Sign In")
    public void loginTest() {
        loginSteps.logIn(testData.ADMIN_USER, testData.ADMIN_PASS);
        loginSteps.logOut();
    }
}