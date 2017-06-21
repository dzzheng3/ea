package edu.mum.onlineshoping.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MsgSender implements MessageCreator {
	private String msg;
	
    public MsgSender(String msg) {
		super();
		this.msg = msg;
	}

	@Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(msg);
    }
}
