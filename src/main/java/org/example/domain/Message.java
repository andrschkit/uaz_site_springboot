package org.example.domain;


import com.sun.istack.NotNull;

import javax.validation.constraints.*;
import javax.persistence.*;

import static org.example.StaticString.*;


@Entity
@Table(name = "message",
        schema="callback")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotBlank(message = MESSAGE_ENTER_NAME)
    @Column(name = "name")
    private String name;

    // 8999-999-99-99
    @NotBlank(message = MESSAGE_ENTER_PHONE_NUMBER)
    @Pattern(regexp = "8-\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = MESSAGE_PATTERN_PHONE_NUMBER)
    @Column(name = "phone_number")
    private String phone_number;

    @Email
    @Column(name = "mail")
    private String mail;
    @Column(name = "msg")
    private String msg;

    public Message() {

    }
    public Message(String name, String phone_number, String mail, String msg) {
        this.name=name;
        this.phone_number=phone_number;
        this.mail=mail;
        this.msg=msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
