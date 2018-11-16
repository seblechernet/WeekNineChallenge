package com.seb.weekninechallenge.Model;


import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private long mssgId;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser from;

    @ManyToOne (fetch = FetchType.EAGER)
    private AppUser to;


    public Message() {
    }

    public Message(String content, AppUser from, AppUser to) {
        this.setContent(content);
        this.setFrom(from);
        this.setTo(to);
    }

    public long getMssgId() {
        return mssgId;
    }

    public void setMssgId(long mssgId) {
        this.mssgId = mssgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AppUser getFrom() {
        return from;
    }

    public void setFrom(AppUser from) {
        this.from = from;
    }

    public AppUser getTo() {
        return to;
    }

    public void setTo(AppUser to) {
        this.to = to;
    }
}
