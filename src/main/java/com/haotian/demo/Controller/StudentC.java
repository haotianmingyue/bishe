package com.haotian.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.demo.Entity.Paper;
import com.haotian.demo.Entity.Question;
import com.haotian.demo.SecondaryDatabase.Dao.PaperDao2;
import com.haotian.demo.SecondaryDatabase.Dao.QuestionDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

@Controller
public class StudentC {

    @Autowired
    private PaperDao2 paperDao2;
    @Autowired
    private QuestionDao2 questionDao2;
    @RequestMapping("/toGetPaper") //考生查看考试列表
    public String getTest(){
        System.out.println("学生");
        return "student/Paper";
    }

    @RequestMapping("/studentGetPaper") //学生得到试卷列表
    @ResponseBody
    public List<Paper> getPaper() throws JsonProcessingException {
        System.out.println("得到试卷列表");
        List<Paper> paperList=paperDao2.findAllByTestIsApproved("是");
        return paperList;
    }
    @RequestMapping("/toStudentShowPaperContent")
    public String toStudentShowPaperContent(HttpServletRequest httpServletRequest,HttpSession httpSession){

        System.out.println("考卷ID"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "student/ShowPaperContent";
    }

    @RequestMapping("/StudentExamQuestion")  //显示当前考卷 所有的问题
    @ResponseBody  // 用于转换对象为json
    public List<Question> ExamQuestionByteacherid(HttpSession httpSession) throws JsonProcessingException {
        String testPaperID=httpSession.getAttribute("TestPaperID").toString();//得到考卷编号
        System.out.println("学生都得到"+testPaperID);
        long testPaperIDl=Long.parseLong(testPaperID);//
        List<Question> questionList=questionDao2.findAllByTestPaperID(testPaperIDl);//得到这个考卷的所有题目
        return questionList;

    }
}
