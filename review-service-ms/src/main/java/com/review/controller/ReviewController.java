package com.review.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.entity.ReviewEntity;
import com.review.serviceImpl.ReviewServiceImpl;

@RequestMapping("/review")
@RestController
public class ReviewController {

	private ReviewServiceImpl reviewServiceImpl;

	public ReviewController(ReviewServiceImpl reviewServiceImpl) {
		super();
		this.reviewServiceImpl = reviewServiceImpl;
	}
	
	@GetMapping("/findAllReviews/{companyId}")
	public List<ReviewEntity> findAllReviews(@PathVariable("companyId") Long companyId) {
		return reviewServiceImpl.findAllReviews(companyId);
	}
	
	@PostMapping("/createReview/{companyId}")
	public ResponseEntity<ReviewEntity> createReview(@RequestBody ReviewEntity reviewEntity,@PathVariable("companyId") Long companyId) {
		ReviewEntity reviewDtls = reviewServiceImpl.createReview(reviewEntity,companyId);
		return new ResponseEntity<>(reviewDtls, HttpStatus.CREATED);
	}
	
	@GetMapping("/getReview/{reviewId}")
	public ResponseEntity<ReviewEntity> getReview(@PathVariable("reviewId") Long reviewId) {
		Optional<ReviewEntity> reviewDtls = reviewServiceImpl.getReview(reviewId);
		return new ResponseEntity<>(reviewDtls.get(), HttpStatus.CREATED);
	}
	
	@GetMapping("/findReviewById/{reviewId}/{companyId}")
	public ResponseEntity<ReviewEntity> findReviewById(@PathVariable("reviewId") Long reviewId,@PathVariable("companyId") Long companyId) {
		ReviewEntity reviewEntity = reviewServiceImpl.findReviewById(reviewId,companyId);
		if (reviewEntity != null)
			return new ResponseEntity<>(reviewEntity, HttpStatus.OK);
		return new ResponseEntity<>(reviewEntity, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteReviewById/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable("reviewId") Long reviewId) {
		 String deleteJobById = reviewServiceImpl.deleteReviewById(reviewId);
		 if(deleteJobById!=null)
	    return new ResponseEntity<>(deleteJobById, HttpStatus.OK);
	    else return new ResponseEntity<>(deleteJobById, HttpStatus.NOT_FOUND);
	}
	
}
