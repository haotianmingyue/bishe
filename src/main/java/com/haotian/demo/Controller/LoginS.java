package com.haotian.demo.Controller;

import com.haotian.demo.Entity.Account;
import com.haotian.demo.MasterDatabase.Dao.QuestionDao;
import com.haotian.demo.SecondaryDatabase.Dao.*;
//import com.haotian.demo.Test.AccountServiceimpl;
import com.haotian.demo.Test.AccountServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haotian.demo.Entity.Account;

@Controller
public class LoginS {
    @Autowired
    private AccountServiceimpl accountDao;
    private Account account;
    @PostMapping("/LoginS")
//    @CachePut(value = "account", key = "#id")
    public String logins(HttpServletRequest request, HttpSession httpSession){
        String accounts=request.getParameter("account");
        long accountl=Long.parseLong(accounts);
        System.out.println(accountl);
        account=accountDao.findById(accountl);
        if(account.getUserPass().equals(request.getParameter("password")))
        {
            if(account.getUserRole().equals("1")){//管理员主页
                httpSession.setAttribute("account",accounts);
                return "admin/adminindex.html";
            }
            if(account.getUserRole().equals("2")){
                httpSession.setAttribute("account",accounts);
                System.out.println(httpSession.getAttribute("account"));
                return "teacher/teaindex";//教师登录主页
            }
            if(account.getUserRole().equals("3")){
                return "student/teacher.html";
            }
            else{
                return "error.html";
            }
        }
        else{
            return "error.html";
        }

        }
//    @Cacheable(value = "account",key="#result.userID")
//    public Account getAccount(long id){
//        System.out.println("查询数据库");
//        return accountDao.findById(id);
//    }


}

