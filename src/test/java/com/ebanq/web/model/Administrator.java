package com.ebanq.web.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Administrator {
    String profileType;
    String userName;
    String firstName;
    String lastName;
    String email;
    String password;
    String status;
    String adminClass;
}
