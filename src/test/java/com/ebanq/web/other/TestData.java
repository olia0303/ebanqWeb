package com.ebanq.web.other;

import utils.PropertyManager;

public class TestData {
    public final String ADMIN_USER;
    public final String ADMIN_PASS;

    public TestData() {
        ADMIN_USER = new PropertyManager().get("username");
        ADMIN_PASS = new PropertyManager().get("password");
    }
}
