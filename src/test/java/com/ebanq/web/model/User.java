package com.ebanq.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    public String email;
    public String password;
    public String name;
}