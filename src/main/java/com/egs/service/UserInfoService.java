package com.egs.service;

import com.egs.dao.IUserInfoDAO;
import com.egs.entity.Account;
import com.egs.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements IUserInfoService {
    @Autowired
    private IUserInfoDAO userInfoDAO;

    @Override
    public String getFullName() {
        return userInfoDAO.getFullName();
    }

    //    @Override
    public UserInfo getUserByName(String userName) {
        return userInfoDAO.getActiveUser(userName);
    }

    @Override
    public Account getAllBalances() {
        return userInfoDAO.getAllBalances();
    }

    @Override
    public void withdraw(double amt) {
        userInfoDAO.withdraw(amt);
    }

    @Override
    public void deposit(double amt) {
        userInfoDAO.deposit(amt);
    }

    public void increaseFailedAttempts(UserInfo user) {
        int newFailAttempts = user.getRetryCount() + 1;
        userInfoDAO.updateFailedAttempts(newFailAttempts, user.getUserName());
    }

    public void resetFailedAttempts(String userName) {
        userInfoDAO.updateFailedAttempts(0, userName);
    }

    public void lock(UserInfo user) {
        user.setBlocked(true);

        userInfoDAO.lock(user.getUserName());
    }
}
