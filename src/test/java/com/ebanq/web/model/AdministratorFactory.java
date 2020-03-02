package com.ebanq.web.model;

import com.ebanq.web.other.TestData;

public class AdministratorFactory {
    
    public static Administrator getAdministrator(String type){
        return Administrator.builder()
                .profileType(type)
                .userName(new TestData().FIRST_NAME)
                .firstName(new TestData().FIRST_NAME)
                .lastName(new TestData().LAST_NAME)
                .email(new TestData().EMAIL)
                .password("Password01!")
                .status("Active")
                .adminClass("Administrator")
                .build();
    }
}