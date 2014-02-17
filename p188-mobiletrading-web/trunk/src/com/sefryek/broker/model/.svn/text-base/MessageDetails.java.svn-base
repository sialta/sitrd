package com.sefryek.broker.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 27, 2011
 * Time: 1:40:42 PM
 */

@Entity
@Table(name = "message_details")
public class MessageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_details_id")
    private Long messageDetailsId;
    @Column(name = "message_details_content_length")
    private int messageContentLength;
    @Column(name = "message_details_content")
    private String messageContent;

    public MessageDetails() {}

    public MessageDetails(int messageContentLength, String messageContent) {
        this.messageContentLength = messageContentLength;
        this.messageContent = messageContent;
    }

    public Long getMessageDetailsId() {
        return messageDetailsId;
    }

    public void setMessageDetailsId(Long messageDetailsId) {
        this.messageDetailsId = messageDetailsId;
    }

    public int getMessageContentLength() {
        return messageContentLength;
    }

    public void setMessageContentLength(int messageContentLength) {
        this.messageContentLength = messageContentLength;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}