package com.elsa.AOPdemo.dao;

import com.elsa.AOPdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{


    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");


    }

    @Override
    public boolean dowork() {

        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
