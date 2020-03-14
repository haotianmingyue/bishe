package com.haotian.demo.Consumer;

import com.haotian.demo.MasterDatabase.Dao.AccountDao;
import com.haotian.demo.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
public class RegisterC {
    @Autowired
    private AccountDao accountDao;
    @JmsListener(destination="springboot.queue")
    public void ListenQueue(Account account) throws JMSException {

        System.out.println(account.getUserID());
        System.out.println(account.getUserPass());
        System.out.println(account.getUserRole());
        accountDao.save(account);
    }
}
