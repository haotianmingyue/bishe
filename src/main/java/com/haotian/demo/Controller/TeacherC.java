package com.haotian.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.haotian.demo.Entity.Test;
import com.haotian.demo.SecondaryDatabase.Dao.TestDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherC {
    @Autowired
    private TestDao2 testDao2;
    @RequestMapping("/toTeacherTest")
    public String teacherGetTestResult(){
        return "teacher/ShowTestResult";
    }
    @RequestMapping("/teacherGetTestResult")//返回已完成考试列表
    @ResponseBody
    public List<Test> getStudentTestResultList(HttpSession httpSession)throws JsonProcessingException {

        Long account=Long.parseLong(httpSession.getAttribute("account").toString());
        System.out.println("出题人账号"+account);
        List<Test>testList=testDao2.findAllByTestQuestionSetterIDAndIsConsult(account,"是");//得到以批阅考试
        System.out.println("得到已完成考试列表");
        return testList;//返回已完成考试列表
    }
}
