package com.haotian.demo.MasterDatabase.Dao;

import com.haotian.demo.Entity.TestMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMessageDao extends JpaRepository<TestMessage,Long> {
}
