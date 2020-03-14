package com.haotian.demo.SecondaryDatabase.Dao;
import com.haotian.demo.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao2 extends JpaRepository<Answer,Long> {
}
