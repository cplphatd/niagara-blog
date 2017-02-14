package com.codeup.models;

import javax.persistence.*;

/**
 * Created by David on 2/8/17.
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 255)
    private String title;

    @Column (nullable = false, length = 1000)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
