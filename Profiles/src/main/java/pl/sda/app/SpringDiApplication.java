package pl.sda.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.sda.beans.NamesRepository;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "pl.sda")
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringDiApplication.class);

        NamesRepository namesRepo= ctx.getBean(NamesRepository.class);
        List<String> allNames = namesRepo.getAll();
        allNames.forEach(System.out::println);

        ctx.close();
    }
}