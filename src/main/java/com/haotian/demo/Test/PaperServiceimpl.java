//package com.haotian.demo.Test;
//
//import com.haotian.demo.Entity.Paper;
//import com.haotian.demo.SecondaryDatabase.Dao.PaperDao2;
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
//public class PaperServiceimpl implements PaperDao2 {
//    @Autowired
//    private PaperDao2 paperDao;
//
//    @Override
//    public List<Paper> findAll() {
//        return paperDao.findAll();
//    }
//
//
//    @Override
//    public List<Paper> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Paper> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Paper> findAllById(Iterable<Long> iterable) {
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
//    public void delete(Paper paper) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Paper> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Paper> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public <S extends Paper> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<Paper> findById(Long aLong) {
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
//    public <S extends Paper> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<Paper> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Paper getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Paper> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Paper> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Paper> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Paper> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Paper> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Paper> boolean exists(Example<S> example) {
//        return false;
//    }
//}
