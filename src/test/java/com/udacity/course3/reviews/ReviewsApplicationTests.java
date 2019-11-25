package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Reviews;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {
	@Autowired
	ReviewsRepository reviewsRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CommentRepository commentRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void reviewTest(){
		productTest();
		Reviews review = new Reviews();
		review.setReview("very good");
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("dina");
		review.setProduct(product);


		System.out.println(review + "test");
		review = reviewsRepository.save(review);
		Assert.assertNotNull("review is null", review);

	}
	@Test
	public void productTest(){
		List<Reviews> reviews = new ArrayList<>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("dina");
		product.setReviews(reviews);
		product = productRepository.save(product);
		Assert.assertNotNull("review is null", product);

	}

/*	@Test
	public void commentTest(){
		Comment comment = new Comment();
		comment.setComment("this is a comment");
		comment.setReviewId(1);
		Assert.assertNotNull("review is null", comment);

	}*/
	@Test
	public void testSaveAndGetComments(){

		reviewTest();
		Comment comment = new Comment("Very good");
		comment.setReviewId(1);
		comment = commentRepository.save(comment);
		Assert.assertNotNull(comment.getCommentId());

		Optional<Comment> savedComment = commentRepository.findById(comment.getCommentId());
		Assert.assertTrue(savedComment.isPresent());
		Assert.assertEquals(comment, savedComment.get());


		List<Comment> comments = commentRepository.findAll();
		Assert.assertTrue(comments.size()>0);

		comments = commentRepository.findAllByReviewId(1);
		Assert.assertTrue(comments.size()>0);

	}
}