package com.haotian.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.demo.Entity.Paper;
import com.haotian.demo.SecondaryDatabase.Dao.PaperDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentC {

    @Autowired
    private PaperDao2 paperDao2;
    @RequestMapping("/toGetPaper") //考生查看考试列表
    public String getTest(){
        System.out.println("学生");
        return "student/Paper";
    }

    @RequestMapping("/studentGetPaper") //学生得到试卷列表
    @ResponseBody
    public List<Paper> getPaper() throws JsonProcessingException {
        List<Paper> paperList=paperDao2.findAllByTestIsApproved("是");
        return paperList;
    }
    @RequestMapping("/toStudentShowPaperContent")
    public String toStudentShowPaperContent(HttpServletRequest httpServletRequest,HttpSession httpSession){

        System.out.println("考卷ID"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "student/ShowPaperContent";
    }
}
