package com.haotian.demo.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StuentTest {
    @RequestMapping("/studenttest")
    public String getTest(){
        return "student/test";
    }
    @RequestMapping("/Paper")
    public String getPaper(){
        return "student/testPaper.html";
    }
}
