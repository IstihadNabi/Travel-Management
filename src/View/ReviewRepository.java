package com.istihad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.istihad.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	public List<Review> findReviewsByUserId(Integer userId);
	
	public List<Review> findReviewsByPlace(String place);
}
