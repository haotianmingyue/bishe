package com.haotian.demo.SecondaryDatabase.Dao;
import com.haotian.demo.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao2 extends JpaRepository<Answer,Long> {
    List<Answer>findAllByTestID(long testid);
}
