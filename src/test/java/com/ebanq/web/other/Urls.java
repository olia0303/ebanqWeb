package com.ebanq.web.other;

import utils.PropertyManager;

public class Urls {
    public static final String LOGIN_PAGE = new PropertyManager().get("application.url.login");
    public static final String MAIN_PAGE_ADMIN = new PropertyManager().get("application.url.admin");
    public static final String ADMIN_PROFILES_PAGE = MAIN_PAGE_ADMIN + "/profiles/administrator-profiles";
    
}
