package com.haotian.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.demo.Entity.Perinformation;
import com.haotian.demo.MasterDatabase.Dao.PerinformationDao;
import com.haotian.demo.SecondaryDatabase.Dao.PerinformationDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CommonC {
    @Autowired
    private PerinformationDao2 perinformationDao2;
    @Autowired
    private PerinformationDao perinformationDao;
    @RequestMapping("/per")
    public String toPerInformation(){
        return "common/PerInformation";
    }
    @RequestMapping("/perinformationDo")
    public String perinformationDo(HttpServletRequest httpServletRequest,HttpSession httpSession){
        System.out.println("个人信息");
//        System.out.println(httpServletRequest.getParameter("userBirth"));
//        System.out.println(httpServletRequest.getParameter("userName"));
//        System.out.println(httpServletRequest.getParameter("userEmail"));
//        System.out.println(httpServletRequest.getParameter("userGender"));
        //Perinformation perinformation=new Perinformation(Long.parseLong(httpSession.getAttribute("account").toString()),httpServletRequest.getParameter("userName"),httpServletRequest.getParameter("userBirth"),httpServletRequest.getParameter("userEmail"),httpServletRequest.getParameter("userGender"));
        Perinformation perinformation=new Perinformation();
        perinformation.setUserID(Long.parseLong(httpSession.getAttribute("account").toString()));
        perinformation.setUserName(httpServletRequest.getParameter("userName"));
        perinformation.setUserBirth(httpServletRequest.getParameter("userBirth"));
        perinformation.setUserEmail(httpServletRequest.getParameter("userEmail"));
        perinformation.setUserGender(httpServletRequest.getParameter("userGender"));
        perinformationDao.save(perinformation);
        System.out.println("个人信息保存成功");
        return "success";
    }
    @RequestMapping("/getPerInformation")
    @ResponseBody
    public Perinformation getPerInformation(HttpSession httpSession) throws JsonProcessingException {
        Long account=Long.parseLong(httpSession.getAttribute("account").toString());
        Perinformation perinformation=perinformationDao2.findByUserID(account);
        System.out.println(perinformation.getUserName()+perinformation.getUserBirth());
        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
        System.out.println(mapper.writeValueAsString(perinformation));
        return perinformation;
    }
}
