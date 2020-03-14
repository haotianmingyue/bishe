package com.haotian.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.demo.Entity.Paper;
import com.haotian.demo.Entity.Question;
import com.haotian.demo.MasterDatabase.Dao.AccountDao;
import com.haotian.demo.MasterDatabase.Dao.PaperDao;
import com.haotian.demo.MasterDatabase.Dao.QuestionDao;
import com.haotian.demo.SecondaryDatabase.Dao.PaperDao2;
import com.haotian.demo.SecondaryDatabase.Dao.QuestionDao2;
//import com.haotian.demo.Test.QuestionServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

@Controller
public class PaperC {
    int state=0;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private QuestionDao2 questionDao2;//从数据库读
    @Autowired
    private PaperDao2 paperDao2;//从数据中读考卷


    private Map<String,Object> result = new HashMap<String,Object>();

    @RequestMapping("/toExam")  //新建试卷
    public String examquestion(HttpSession httpSession){
        LocalDateTime dateTime = LocalDateTime.now();//获取当前时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");//格式化
        Paper paper=new Paper();
        paper.setTestPaperTime(dateTime.format(formatter));
        String account=httpSession.getAttribute("account").toString();
//        System.out.println("setTestQuestionSetterID"+account);
        long accountl=Long.parseLong(account);
        paper.setTestQuestionSetterID(accountl);
        paper.setTestPaperTotalTime("60");//默认60分钟
        paper.setTestIsApproved("否");//默认未通过审核
        System.out.println(paper.getTestPaperTime()+paper.getTestPaperTotalTime());
        Paper paper1= paperDao.save(paper);//存入Paper数据库中
        httpSession.setAttribute("TestPaperID",paper1.getTestPaperID());
//        System.out.println("TestPaperID"+paper1.getTestPaperID());
        return "teacher/Exam";
    }

    @RequestMapping("/saveExamQuestions")
    @ResponseBody
    public Map<String,Object> saveExamQuestions(Question question, HttpServletRequest request,HttpSession httpSession,Integer testQuestionID){
        try {

//            System.out.println("idiididiid"+question.getTestQuestionID()+request.getParameter("testQuestionID")+testQuestionID);
            System.out.println("数据库添加完毕");
            question.setTestPaperID(Long.parseLong(httpSession.getAttribute("TestPaperID").toString()));
            question.setTestQuestionContent(question.getTestQuestionContent());
            question.setTestQuestionTrueAns(question.getTestQuestionTrueAns());
            question.setTestQuestionScore(question.getTestQuestionScore());
            questionDao.save(question);//主数据库存
            state=1;
            if(question.getTestQuestionContent().equals("null"))
                result.put("success",false);
            else
                result.put("success", true);



        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;

    }

    @RequestMapping("/updateExamQuestions")
    @ResponseBody
    public Map<String,Object> updateExamQuestions(Question question, HttpServletRequest request,HttpSession httpSession,Integer testQuestionID){
        try {

//            System.out.println("testQuestionid"+question.getTestQuestionID());
            Question question1=new Question();
            question1.setTestPaperID(Long.parseLong(httpSession.getAttribute("TestPaperID").toString()));
            question1.setTestQuestionContent(question.getTestQuestionContent());
            question1.setTestQuestionTrueAns(question.getTestQuestionTrueAns());
            question1.setTestQuestionScore(question.getTestQuestionScore());
            questionDao.deleteById(question.getTestQuestionID());//删除前一个
            questionDao.save(question1);//新加数据
            if(question.getTestQuestionContent().equals("null"))
                result.put("success",false);
            else
                result.put("success", true);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;

    }
    @RequestMapping("/getPaper") //得到历史试卷
    @ResponseBody
    public List<Paper> getPaper(HttpSession httpSession) throws JsonProcessingException {

        String account=httpSession.getAttribute("account").toString();//得到账号
        long testQuestionSetterID=Long.parseLong(account);
        System.out.println("得到出题人账号"+testQuestionSetterID);
        List<Paper> paperList=paperDao2.findAllByTestQuestionSetterID(testQuestionSetterID);
        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
        System.out.println(mapper.writeValueAsString(paperList));

        return paperList;
    }
    @RequestMapping("/ExamQuestion")  //显示当前考卷 所有的问题
    @ResponseBody  // 用于转换对象为json
    public List<Question> ExamQuestionByteacherid(HttpSession httpSession,@RequestParam(value = "page")Integer page, @RequestParam(value = "rows")Integer size) throws JsonProcessingException, AWTException {
        String testPaperID=httpSession.getAttribute("TestPaperID").toString();//得到考卷编号
        long testPaperIDl=Long.parseLong(testPaperID);//
        System.out.println(testPaperIDl);
        //Page<Question> findAllByTestestPaperID(testPaperIDl,)
        System.out.println(testPaperIDl);
//        Timer timer = new Timer();// 实例化Timer类  //注意主从数据库中 刚在主数据库中写入数据，又在从数据库中读，可能会读不到.
//        List<Question> questionList=new ArrayList<>();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                System.out.println("退出");
//                this.cancel();
//            }
//        }, 5000);// 这里百毫秒
//        System.out.println("本程序存在5秒后自动退出");

        List<Question> questionList=questionDao.findAllByTestPaperID(testPaperIDl);//得到这个考卷的所有题目
//        List<Question> questionList=questionDao2.findAllByTestPaperID(testPaperIDl);//得到这个考卷的所有题目
        System.out.println("数据库刷新");
        System.out.println(questionList.size());
        return questionList;

        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        // 分页
//        questionDao2.findAll(new PageRequest(page,size));
//        List<Question> questionList =questionDao2.findAll();
//        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
//        System.out.println(mapper.writeValueAsString(questionList));


    }
    @RequestMapping("/findExamQuestionsById")  //修改表格时的查找具体问题
    @ResponseBody
    public Question findExamQuestionsById(Integer testQuestionID){
        System.out.println("testQuestionID "+testQuestionID);

        Question question=questionDao2.findById(testQuestionID);
        return question;
    }

    @RequestMapping("/deleteTestQuestion") //删除问题
    @ResponseBody
    public Map<String,Object> delete(long testQuestionID){
        try {
//            System.out.println("idididiidididi"+testQuestionID);
            questionDao.deleteById(testQuestionID);
            //adminUserService.deleteLoginUser(id);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

//    @RequestMapping(value = "/displayAll",method = RequestMethod.GET)
//    public Map<String,java.lang.Object> findAllDepartments(@RequestParam(value = "page")Integer page, @RequestParam(value = "rows")Integer size){
//        Page<Question> list= questionDao2.findAllByTestPaperID(new PageRequest(page-1,size));
//        Map<String,java.lang.Object> map = new HashMap<String,java.lang.Object>();
////        int total = questionDao2.findAllByTestestPaperID().size();
////        map.put("total",total);
////        map.put("rows",list.getContent());
//        return map ;
//    }

    @RequestMapping("/toPaper")  //查询自己发布的考卷
    public String getPaper(){
        return "teacher/Paper";

    }
    @RequestMapping("/toShowPaperContent")//查看考卷详细信息
    public String showPaperContent(HttpServletRequest httpServletRequest,HttpSession httpSession){
        System.out.println("试卷编号"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "teacher/ShowPaperContent";
    }
    @RequestMapping("/toShowManagePaperContent")//管理员查看考卷详细信息
    public String showManagePaperContent(HttpServletRequest httpServletRequest,HttpSession httpSession){
        System.out.println("试卷编号"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "admin/ShowPaperContent";
    }
    @RequestMapping("/test")
    public  String test(){
        return "teacher/unuse.html";
    }




}
