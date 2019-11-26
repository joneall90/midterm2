package com.udacity.course3.reviews.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "productId", nullable = false)
    @JsonIgnore
    private Product product;
    private String review;

    @OneToMany(mappedBy = "product")
    private List<Reviews> reviews = new ArrayList<>();

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void Review(){}
}