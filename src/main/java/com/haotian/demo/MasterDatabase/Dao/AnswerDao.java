package com.haotian.demo.MasterDatabase.Dao;
import com.haotian.demo.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao extends JpaRepository<Answer,Long> {
}
