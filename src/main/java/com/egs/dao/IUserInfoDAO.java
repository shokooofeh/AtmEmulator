package com.egs.dao;

import com.egs.entity.Account;
import com.egs.entity.UserInfo;

public interface IUserInfoDAO {
    UserInfo getActiveUser(String userName);

    String getFullName();

    Account getAllBalances();

    void withdraw(double amt);

    void deposit(double amt);
}
