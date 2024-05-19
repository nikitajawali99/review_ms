package com.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.swing.RepaintManager;

import org.springframework.stereotype.Service;

import com.review.entity.ReviewEntity;
import com.review.repository.ReviewRepository;

@Service
public class ReviewServiceImpl {

	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}

	public List<ReviewEntity> findAllReviews(Long companyId) {
		return reviewRepository.findByCompany(companyId);
	}

	public ReviewEntity createReview(ReviewEntity reviewEntity, Long companyId) {
		if(companyId!=null && reviewEntity!=null) {
			reviewEntity.setCompanyId(companyId);
		}
		return reviewRepository.save(reviewEntity);
	}

	public ReviewEntity findReviewById(Long reviewId, Long companyId) {
		// TODO Auto-generated method stub
		return reviewRepository.findReviewById(reviewId,companyId);
	}

	public String deleteReviewById(Long reviewId) {
		reviewRepository.deleteByReviewCompanyId(reviewId);
		return "Review deleted successfully ";
	}

	public Optional<ReviewEntity> getReview(Long reviewId) {
		// TODO Auto-generated method stub
		return reviewRepository.findById(reviewId);
	}

}
