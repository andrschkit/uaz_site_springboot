package org.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static org.example.StaticString.MESSAGE_ENTER_NAME;

@Entity
@Table(name = "note",
        schema="notes")
public class MediaPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
