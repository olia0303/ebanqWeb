package com.ebanq.web.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Account {
    public String accountNumber;
    public String accountType;
    public String user;
    public String status;
    public String initialBalance;
}