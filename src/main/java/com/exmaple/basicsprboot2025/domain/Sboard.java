package com.exmaple.basicsprboot2025.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Sboard {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Setter String title;
    @Setter String content;
    @Setter String author;

    public Sboard(){}
    public Sboard(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }*/
}
