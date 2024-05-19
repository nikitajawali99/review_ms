package com.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.review.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

	@Query("select p from ReviewEntity p where p.id=:reviewId and p.companyId=:companyId")
	ReviewEntity findReviewById(@Param("reviewId") Long reviewId, @Param("companyId") Long companyId);

	@Query("select p from ReviewEntity p where p.companyId=:companyId")
	List<ReviewEntity> findByCompany(@Param("companyId") Long companyId);

	@Query(value="Delete * from review p where p.id=:reviewId",nativeQuery = true)
	void deleteByReviewCompanyId(@Param("reviewId") Long reviewId);

}
