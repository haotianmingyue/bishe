package com.haotian.demo.SecondaryDatabase.Dao;

import com.haotian.demo.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao2 extends JpaRepository<Test,Long> {
    List<Test>findAllByTestRespondentID(long testRespondentID);
    List<Test>findAllByTestRespondentIDAndIsConsult(long testRespondentID,String isConsult);
    List<Test>findAllByTestQuestionSetterIDAndIsConsult(long testSetterID,String isConslut);
    Test findByTestID(long testID);
}
