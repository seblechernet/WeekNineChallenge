package com.seb.weekninechallenge.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private long userId;
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "aboutyou")
    private String aboutYou;



    @Column(name = "picture")
    private String picture;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name ="role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "from")
    private List<Message> inbox;

    @OneToMany(mappedBy = "postedBy")
    private List<Post> posts;


    @OneToMany(mappedBy = "to")
    private List<Message> sent;
    public AppUser() {

        inbox=new ArrayList<>();
        posts=new ArrayList<>();
        sent=new ArrayList<>();
        roles=new ArrayList<>();

    }

    public AppUser(String email, String password, String firstName, String lastName, boolean enabled, String userName,String aboutYou) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEnabled(enabled);
        this.setUserName(userName);
        this.setAboutYou(aboutYou);

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(passsword);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public List<Message> getInbox() {
        return inbox;
    }

    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Message> getSent() {
        return sent;
    }

    public void setSent(List<Message> sent) {
        this.sent = sent;
    }
}

