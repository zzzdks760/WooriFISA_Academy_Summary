package dev.syntax.aop;

import dev.syntax.aop.config.BeanConfiguration;
import dev.syntax.aop.controller.CoffeeController;
import dev.syntax.aop.model.Coffee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        CoffeeController coffeeController = ctx.getBean(CoffeeController.class);
//        coffeeController.getCoffees();

        coffeeController.saveCoffee(new Coffee(1, "페퍼민트"));

    }
}
