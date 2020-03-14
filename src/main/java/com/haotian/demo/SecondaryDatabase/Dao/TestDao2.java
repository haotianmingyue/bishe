package com.haotian.demo.SecondaryDatabase.Dao;

import com.haotian.demo.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao2 extends JpaRepository<Test,Long> {
}
