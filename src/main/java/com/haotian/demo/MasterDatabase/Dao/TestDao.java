package com.haotian.demo.MasterDatabase.Dao;

import com.haotian.demo.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<Test,Long> {
}
