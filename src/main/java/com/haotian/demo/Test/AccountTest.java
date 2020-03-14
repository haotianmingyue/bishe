//package com.haotian.demo.Test;
//import com.haotian.demo.Dao.AccountDao;
//import com.haotian.demo.Entity.Account;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AccountTest {
//    @Autowired
//    private AccountDao accountDao;
//    @Before
//    public void before(){
//        Account account=new Account();
//        account.setUserID(123456789);
//        account.setUserPass("123456");
//        account.setUserRole("3");
//        accountDao.save(account);
//
//    }
//    @Test
//    public void Add(){
//        Account account=new Account();
//        account.setUserID(1);
//        account.setUserPass("123456");
//        account.setUserRole("3");
//        accountDao.save(account);
//
//    }
//}
