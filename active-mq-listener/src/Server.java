import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Server implements MessageListener {
    private static int ackMode;
    private static String messageQueueName;
    private static String messageBrokerUrl;
 
    private Session session;
    private boolean transacted = false;
    private MessageProtocol messageProtocol;
 
    static {
        messageBrokerUrl = "tcp://10.201.232.125:61616";
        messageQueueName = "test-rios";
        ackMode = Session.AUTO_ACKNOWLEDGE;
    }
 
    public Server() throws InterruptedException {
        try {
        	System.out.println("Initializing server");
            //Delegating the handling of messages to another class, instantiate it before setting up JMS so it
            //is ready to handle messages
            this.messageProtocol = new MessageProtocol();
            this.setupMessageQueueConsumer();
            System.out.println("Server initialized");
        } catch (Exception e) {
            //Handle the exception appropriately
        	e.printStackTrace();
        }
    }
 
    private void setupMessageQueueConsumer() throws InterruptedException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(messageBrokerUrl);
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            this.session = connection.createSession(this.transacted, ackMode);
            Destination adminQueue = this.session.createQueue(messageQueueName);

            //Set up a consumer to consume messages off of the admin queue
            MessageConsumer consumer = this.session.createConsumer(adminQueue);
            consumer.setMessageListener(this);
            Thread.sleep(60 * 1000);
        } catch (JMSException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public void onMessage(Message message) {
        try {
        	System.out.println("Message received");
            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                String messageText = txtMsg.getText();
                this.messageProtocol.handleProtocolMessage(messageText);
            }

        } catch (JMSException e) {
            //Handle the exception appropriately
        	e.printStackTrace();
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        new Server();
    }
}