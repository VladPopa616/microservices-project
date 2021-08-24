package com.popa.microservices.core.review.businesslayer;

import com.popa.api.core.review.Review;

import java.util.List;

public interface ReviewService {

    public List<Review> getProductById(int productId);

    public Review createReview(Review model);

    public void deleteReviews(int productId);

}
