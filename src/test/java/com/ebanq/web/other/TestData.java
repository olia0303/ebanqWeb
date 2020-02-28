package com.ebanq.web.other;

import com.github.javafaker.Faker;
import utils.PropertyManager;

public class TestData {
    Faker generator;
    public final String ADMIN_USER;
    public final String ADMIN_PASS;
    public final String FIRST_NAME;
    public final String LAST_NAME;
    public final String EMAIL;

    public TestData() {
        generator = new Faker();
        FIRST_NAME = generator.name().firstName();
        LAST_NAME = generator.name().lastName();
        EMAIL = generator.name().lastName() + "@gmail.com";
        ADMIN_USER = new PropertyManager().get("username");
        ADMIN_PASS = new PropertyManager().get("password");
        
    }
}
