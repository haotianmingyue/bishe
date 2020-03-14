//package com.haotian.demo.Consumer;
//
//import com.haotian.demo.Entity.Account;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Consumer {
//    //接收queue类型消息
//    //destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
//    @JmsListener(destination="springboot.queue")
//    public void ListenQueue(Account account) {
//        //System.out.println("接收到queue消息：" + msg);
//        System.out.println(account.getUserID());
//        System.out.println(account.getUserPass());
//        System.out.println(account.getUserRole());
//    }
//    //接收topic类型消息
//    //destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
//    //containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
//    @JmsListener(destination="springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
//    public void ListenTopic(String msg){
//        System.out.println("接收到topic消息：" + msg);
//    }
//}
