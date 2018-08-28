import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class OnMessageListener implements MessageListener {
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("OnMessageListener received " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
