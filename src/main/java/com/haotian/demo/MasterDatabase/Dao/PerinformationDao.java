package com.haotian.demo.MasterDatabase.Dao;

import com.haotian.demo.Entity.Perinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerinformationDao extends JpaRepository<Perinformation,Long> {
}
