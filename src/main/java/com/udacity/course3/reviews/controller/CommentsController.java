package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.Reviews;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    ReviewsRepository reviewsRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CommentRepository commentRepository;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Reviews reviewId, @RequestBody Comment comment) {
        Optional<Reviews> review = reviewsRepository.findById(reviewId.getReviewId());
        if(review.isPresent()){
            comment.setReviewId(reviewId);
            comment = commentRepository.save(comment);
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     * @return
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Optional<Reviews> review = reviewsRepository.findById(reviewId);
        if(review.isPresent()){
            List<Comment> comments = commentRepository.findAllByReviewId(reviewId);
            return ResponseEntity.ok(comments);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}