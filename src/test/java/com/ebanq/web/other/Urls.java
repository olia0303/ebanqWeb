package com.ebanq.web.other;

import utils.PropertyManager;

public class Urls {
    public static final String LOGIN_PAGE = new PropertyManager().get("application.url.ebanq") + "/log-in";
    public static final String ACCOUNTS_PAGE = new PropertyManager().get("application.url.ebanq") + "/admin/accounts/accounts";
    public static final String ACCOUNTS_PAGE_USER = new PropertyManager().get("application.url.ebanq") + "/my-accounts";
    public static final String CARDS_PAGE = new PropertyManager().get("application.url.ebanq") + "/admin/accounts/cards";
    public static final String CREATE_CARDS_PAGE = new PropertyManager().get("application.url.ebanq") + "/admin/accounts/cards/create";
    public static final String CREATE_ACCOUNTS_PAGE = new PropertyManager().get("application.url.ebanq") + "/admin/accounts/accounts/create";
    public static final String MAIN_PAGE_ADMIN = new PropertyManager().get("application.url.ebanq") + "/admin";
    public static final String ADMIN_PROFILES_PAGE = MAIN_PAGE_ADMIN + "/profiles/administrator-profiles";
    public static final String TRANSFER_PAGE = new PropertyManager().get("application.url.ebanq") + "/transfer";
    public static final String REQUESTS_PAGE = new PropertyManager().get("application.url.ebanq") + "/admin/requests";
    public static final String REPORTS_PAGE = new PropertyManager().get("application.url.ebanq") + "/user-reports/specific-account-statement";
}