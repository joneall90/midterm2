package com.udacity.course3.reviews.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "reviewId", nullable = false)
    @JsonIgnore
    private Reviews reviewId;

    private String comment;

    public Comment(String comment) {
        this.setComment(comment);
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Reviews getReviewId() {
        return reviewId;
    }

    public void setReviewId(Reviews reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Comment(){}
}