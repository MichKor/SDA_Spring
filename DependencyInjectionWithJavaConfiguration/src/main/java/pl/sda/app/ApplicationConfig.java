package pl.sda.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.beans.MessagePrinter;
import pl.sda.beans.MessageProducer;
import pl.sda.beans.SimpleMessageProducer;

@Configuration
public class ApplicationConfig {

    @Bean
    public MessagePrinter getPrinter() {
        MessageProducer producer = new SimpleMessageProducer();
        return new MessagePrinter(producer);
    }
}