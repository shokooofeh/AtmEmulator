package com.egs.service;

import com.egs.entity.Account;
import org.springframework.security.access.annotation.Secured;

public interface IUserInfoService {
    String getFullName();

    @Secured({"ROLE_ADMIN"})
    Account getAllBalances();

    void withdraw(double amt);

    void deposit(double amt);
}
