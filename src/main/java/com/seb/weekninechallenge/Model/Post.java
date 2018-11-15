package com.seb.weekninechallenge.Model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long postId;
    private  String title;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser postedBy;


    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

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

    public AppUser getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(AppUser postedBy) {
        this.postedBy = postedBy;
    }
}

