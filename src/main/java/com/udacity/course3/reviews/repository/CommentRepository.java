package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByReviewId (int reviewID);
}
