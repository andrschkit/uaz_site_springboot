package org.example.domain;


import javax.persistence.*;


@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phone_number;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
