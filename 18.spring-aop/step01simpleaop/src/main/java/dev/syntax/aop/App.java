package dev.syntax.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserController withoutAOP = (UserController) context.getBean("userController");

//        withoutAOP.getUsers();

        UserController withAOP = (UserController) context.getBean("proxyFactoryBean");
        withAOP.getUsers();
    }
}
