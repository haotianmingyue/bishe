package com.haotian.demo.MasterDatabase.Dao;

import com.haotian.demo.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<Account,Long> {
    Account findById(long UserID);
    List<Account> findAllByUserRole(String UserRole);
}
