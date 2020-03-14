package com.haotian.demo.MasterDatabase.Dao;

import com.haotian.demo.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Long> {
//    List<Question> findByTestPaperID(Long testPaperID);
//    @Modifying
//    @Query("update question set q")
//    Question updateByTe
// Question updateByID(long id);
List<Question> findAllByTestPaperID(long testPaperID);
}
