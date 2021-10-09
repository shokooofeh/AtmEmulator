package com.egs.service;

import com.egs.dao.IUserInfoDAO;
import com.egs.entity.Account;
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

    @Override
    public Account getAllBalances() {
        return userInfoDAO.getAllBalances();
    }

     @Override
    public void withdraw(double amt){
        userInfoDAO.withdraw(amt);
    }

    @Override
    public void deposit(double amt){
        userInfoDAO.deposit(amt);
    }
}
