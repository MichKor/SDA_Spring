package pl.sda;

public class Main {
    public static void main(String[] args) {
        MessageProducer fileMsgProducer = new FileMessageProducer();
        MessagePrinter filePrinter = new MessagePrinter(fileMsgProducer);
        filePrinter.printMessage();

        MessageProducer simpleMessageProducer = new SimpleMessageProducer();
        MessagePrinter simplePrinter = new MessagePrinter(simpleMessageProducer);
        simplePrinter.printMessage();
    }
}