package com.haotian.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.demo.Entity.Paper;
import com.haotian.demo.MasterDatabase.Dao.PaperDao;
import com.haotian.demo.MasterDatabase.Dao.QuestionDao;
import com.haotian.demo.SecondaryDatabase.Dao.PaperDao2;
import com.haotian.demo.SecondaryDatabase.Dao.QuestionDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminC {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private QuestionDao2 questionDao2;//从数据库读
    @Autowired
    private PaperDao2 paperDao2;//从数据中读考卷

    @RequestMapping("/tomanagePaper")  //管理试卷
    public String getPaper(){
         return"admin/managePaper";

     }
    @RequestMapping("/getManagePaper") //得到历史试卷
    @ResponseBody
    public List<Paper> getPaper(HttpSession httpSession) throws JsonProcessingException {

        //String account=httpSession.getAttribute("account").toString();//得到账号
        //long testQuestionSetterID=Long.parseLong(account);
        System.out.println("管理员得到试卷");
        List<Paper> paperList=paperDao2.findAllByTestIsApproved("否");//得到所有考卷
//        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
//        System.out.println(mapper.writeValueAsString(paperList));
        return paperList;
    }
    @RequestMapping("/tomanageTeacher")//管理教师账号
    public String setTeacher(HttpServletRequest httpServletRequest,HttpSession httpSession){
        System.out.println("身份");
        System.out.println("shenfen"+httpServletRequest.getParameter("userRole"));
        httpSession.setAttribute("userRole2",httpServletRequest.getParameter("userRole"));//保存身份  不要用一个userRole 不安全
        httpSession.setAttribute("userRole3","null");//不写会报空指针
        System.out.println(httpSession.getAttribute("userRole2"));
        return "admin/manageteacher";

    }
    @RequestMapping("/tomanageStudent")//管理学生账号
    public String setStudent(HttpServletRequest httpServletRequest,HttpSession httpSession){
        System.out.println("身份");
        System.out.println("shenfen"+httpServletRequest.getParameter("userRole"));
        httpSession.setAttribute("userRole3",httpServletRequest.getParameter("userRole"));//保存身份
        httpSession.setAttribute("userRole2","null");
        return "admin/managestudent";
    }
    @RequestMapping("/checkPaper")
    @ResponseBody
    public void checkPaper(HttpSession httpSession){
        System.out.println("审核通过");
        System.out.println("试卷id"+httpSession.getAttribute("TestPaperID"));
        long testPaperID=Long.parseLong(httpSession.getAttribute("TestPaperID").toString());
        Paper paper=paperDao.findByTestPaperID(testPaperID);
//        System.out.println(paper.getTestPaperTotalTime());
//        System.out.println(paper.getTestPaperTime());
        paper.setTestIsApproved("是");
        paperDao.save(paper);//保存数据

    }

}
