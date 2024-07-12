package com.elsa.AOPdemo.dao;

import com.elsa.AOPdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean dowork();
}
