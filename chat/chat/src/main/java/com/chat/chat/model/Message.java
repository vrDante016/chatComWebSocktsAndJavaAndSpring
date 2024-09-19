package com.chat.chat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("from")
    @Column(name = "sender",length = 20, nullable = false)
    private String from;
    @Column(length = 500, nullable = false)
    private String content;
    @Column(nullable = false)
    private Timestamp moment;

    public Message(){

    }

    public Message(String from, String content, Timestamp moment) {
        this.from = from;
        this.content = content;
        this.moment = moment;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getMoment() {
        return moment;
    }

    public void setMoment(Timestamp moment) {
        this.moment = moment;
    }
}
