package com.sefryek.broker.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 27, 2011
 * Time: 1:34:42 PM
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private Long messageId;
    @Column(name = "message_subject_length")
    private byte messageSubjectLength;
    @Column(name = "message_subject")
    private String messageSubject;
    @Column(name = "message_status")
    private byte messageStatus;
    @Column(name = "message_date")
    private Date messageDate;

    public Message() {}

    public Message(byte messageSubjectLength, String messageSubject, byte messageStatus) {
        this.messageSubjectLength = messageSubjectLength;
        this.messageSubject = messageSubject;
        this.messageStatus = messageStatus;
        this.messageDate = new Date();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public byte getMessageSubjectLength() {
        return messageSubjectLength;
    }

    public void setMessageSubjectLength(byte messageSubjectLength) {
        this.messageSubjectLength = messageSubjectLength;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public byte getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(byte messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}