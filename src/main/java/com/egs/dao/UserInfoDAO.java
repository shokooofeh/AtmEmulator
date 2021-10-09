package com.egs.dao;

import com.egs.entity.Account;
import com.egs.entity.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {
    private int userId;
    private String fullName;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();
        List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? AND is_blocked=0 ")
                .setParameter(1, userName).getResultList();
        if (!list.isEmpty())
            activeUserInfo = (UserInfo) list.get(0);

        this.userId = activeUserInfo.getUserId();
        this.fullName = activeUserInfo.getFullName();
        return activeUserInfo;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Account getAllBalances() {
        String hql = "FROM Account as atcl WHERE atcl.accountId=" + userId;
        return ((List<Account>) entityManager.createQuery(hql).getResultList()).get(0);
    }

    @Override
    public void withdraw(double amt) {
        Query withdrawQuery = entityManager.createQuery("update Account set balance=balance-:amt where account_id =:userId");
        withdrawQuery.setParameter("amt", amt);
        withdrawQuery.setParameter("userId", this.userId);
        withdrawQuery.executeUpdate();
    }

    @Override
    public void deposit(double amt) {
        Query depositQuery = entityManager.createQuery("update Account set balance=balance+:amt where account_id =:userId");
        depositQuery.setParameter("amt", amt);
        depositQuery.setParameter("userId", this.userId);
        depositQuery.executeUpdate();
    }
}
