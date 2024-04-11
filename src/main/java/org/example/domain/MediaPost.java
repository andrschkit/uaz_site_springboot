package org.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Base64;

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
    @Lob
    @Column(name = "title_image")
    private String title_image;
    @Column(name = "short_content")
    private String short_content;

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
    public String getTitle_image() {
        return title_image;
    }

    public void setTitle_image(String title_image) {
        this.title_image = title_image;
    }
    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
