package org.example.domain;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Transactional
@Table(name = "note",
        schema="notes")
public class MediaPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "modify_date")
    private Timestamp modifyDate;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
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
