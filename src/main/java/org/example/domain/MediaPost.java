package org.example.domain;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;

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
    private String titleImage;
    @Column(name = "short_content")
    private String shortContent;


    public MediaPost() {
    }

    public MediaPost(String title, String content, MultipartFile titleImage, String shortContent) throws IOException {
        setTitleImage(titleImage);
        this.title = title;
        this.content = content;
        this.shortContent = shortContent;
    }

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
    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String title_image) {
        this.titleImage = title_image;
    }

    public void setTitleImage(MultipartFile titleImage) throws IOException {
        this.titleImage =  Base64.getEncoder().encodeToString(titleImage.getBytes());
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String short_content) {
        this.shortContent = short_content;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
