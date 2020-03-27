package com.haotian.demo.SecondaryDatabase.Dao;

import com.haotian.demo.Entity.Perinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerinformationDao2 extends JpaRepository<Perinformation,Long> {
Perinformation findByUserID(long userID);
}
