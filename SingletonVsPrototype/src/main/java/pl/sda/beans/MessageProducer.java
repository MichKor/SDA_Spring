package pl.sda.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessageProducer {

    private int number;

    public MessageProducer() {
        number = new Random().nextInt();
    }

    public int getNumber() {
        return number;
    }
}