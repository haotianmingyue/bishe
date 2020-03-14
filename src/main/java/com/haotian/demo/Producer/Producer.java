//package com.haotian.demo.Producer;
//
//import com.haotian.demo.Entity.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.jms.JMSException;
//import javax.jms.Queue;
//import javax.jms.Topic;
//
//@Controller
//public class Producer {
//    @Autowired
//    private JmsMessagingTemplate jmsTemplate;
//
//    @Autowired //自动注入了Config文件中的写的 Bean 主要作用是  隐藏名称
//    private Queue queue;
//
//    @Autowired
//    private Topic topic;
//
//    private Account account;
//
//    //发送queue类型消息
//    @GetMapping("/queue")
//    public String sendQueueMsg(String msg) throws JMSException {
//        //jmsTemplate.convertAndSend(queue, msg);
//        //jmsTemplate.convertAndSend(queue, msg);
//        //System.out.println(queue);
//        //System.out.println(queue.getQueueName());
//        account=new Account();
//        account.setUserID(12345648);
//        account.setUserPass("123456");
//        account.setUserRole("3");
//        jmsTemplate.convertAndSend(queue,account);
//
//        return "index.html";
//    }
//
//    //发送topic类型消息
//    @GetMapping("/topic")
//    public void sendTopicMsg(String msg){
//        jmsTemplate.convertAndSend(topic, msg);
//    }
//}
