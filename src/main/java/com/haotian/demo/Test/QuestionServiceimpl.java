//package com.haotian.demo.Test;
//
//import com.haotian.demo.Entity.Question;
//import com.haotian.demo.MasterDatabase.Dao.QuestionDao;
//import com.haotian.demo.SecondaryDatabase.Dao.QuestionDao2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@CacheConfig(cacheNames = "userService")
//public class QuestionServiceimpl implements QuestionDao2 {
//    @Autowired
//    private QuestionDao2 questionDao2;
//
//    public List<Question> findByTestPaperID(long testPaperID) {
//        return questionDao2.findByTestPaperID(testPaperID);
//    }//根据试卷编号求得问题
//
//    @Override
//    public List<Question> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Question> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Question> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Question> findAllById(Iterable<Long> iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Question question) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Question> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Question> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public <S extends Question> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<Question> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Question> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<Question> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Question getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Question> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Question> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Question> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Question> boolean exists(Example<S> example) {
//        return false;
//    }
//}
