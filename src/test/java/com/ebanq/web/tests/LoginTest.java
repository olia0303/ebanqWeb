package com.ebanq.web.tests;

import com.ebanq.web.other.TestData;
import com.ebanq.web.tests.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(description = "Sign In")
    public void loginTest() {
        loginSteps.login(new TestData().ADMIN_USER, new TestData().ADMIN_PASS);
        loginSteps.logOut();
    }
}
