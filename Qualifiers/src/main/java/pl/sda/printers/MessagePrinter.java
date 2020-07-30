package pl.sda.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sda.detectors.MessageDecorator;
import pl.sda.producers.MessageProducer;

@Component
public class MessagePrinter {

    private MessageProducer producer;
    private MessageDecorator decorator;

    @Autowired
    public MessagePrinter(@Qualifier("fileMessageProducer") MessageProducer producer) {
        this.producer = producer;
    }

    public MessageDecorator getDecorator() {
        return decorator;
    }

    @Autowired(required = false)
    public void setDecorator(MessageDecorator decorator) {
        this.decorator = decorator;
    }

    public void print() {
        String message = producer.getMessage();
        message = decorator != null? decorator.decorate(message) : message;
        System.out.println(message);
    }
}