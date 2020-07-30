package pl.sda.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.sda.beans.MessageProducer;

@Configuration
@ComponentScan(basePackages = "pl.sda")
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

        MessageProducer bean1 = ctx.getBean(MessageProducer.class);
        System.out.println(bean1.getNumber());
        MessageProducer bean2 = ctx.getBean(MessageProducer.class);
        System.out.println(bean2.getNumber());
        MessageProducer bean3 = ctx.getBean(MessageProducer.class);
        System.out.println(bean3.getNumber());
        MessageProducer bean4 = ctx.getBean(MessageProducer.class);
        System.out.println(bean4.getNumber());
        MessageProducer bean5 = ctx.getBean(MessageProducer.class);
        System.out.println(bean5.getNumber());

        ctx.close();
    }
}