package com.app.socialnetwork.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("message")
@Scope("prototype")
@Entity
@Table(name = "MESSAGE_MASTER")
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
	
	@Column(name = "MESSAGE_DESCRIPTION", length = 50)
    private String messageDescription;


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}


	public String getMessageDescription() {
		return messageDescription;
	}


	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}


	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageDescription=" + messageDescription + "]";
	}
    

}
