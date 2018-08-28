import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Publisher{
	
	public void sendMessage(){
	    try {
	        // Create a ConnectionFactory
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://10.201.232.125:61616");

	        // Create a Connection
	        javax.jms.Connection connection = connectionFactory.createConnection();
	        connection.start();

	        // Create a Session
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	        // Create the destination (Topic or Queue)
	        Destination destination = session.createQueue("test-rios");
	        
	        // Create a MessageProducer from the Session to the Topic or Queue
	        MessageProducer producer = session.createProducer(destination);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        
	        //MessageConsumer consumer = session.createConsumer(destination);
	        //consumer.setMessageListener(new OnMessageListener());

	        // Create a messages
	        String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
	        TextMessage message = session.createTextMessage(text);

	        // Tell the producer to send the message
	        System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
	        producer.send(message);
	        
	         Thread.sleep(1000);

	        // Clean up
	        session.close();
	        connection.close();
	    }
	    catch (Exception e) {
	        System.out.println("Caught: " + e);
	        e.printStackTrace();
	    }
	}
}


