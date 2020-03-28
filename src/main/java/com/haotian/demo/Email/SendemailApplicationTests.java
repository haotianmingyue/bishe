//package com.haotian.demo.Email;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SendemailApplicationTests {
//
//    /**
//     * 注入发送邮件的接口
//     */
//    @Autowired
//    private IMailService mailService;
//
//    /**
//     * 测试发送文本邮件
//     */
//    @Test
//    public void sendmail() {
//        mailService.sendSimpleMail("2421912570@qq.com","zhuti","content");
//    }
//
//    @Test
//    public void sendmailHtml(){
//        mailService.sendHtmlMail("2540097595@qq.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
//    }
//}
//
//
