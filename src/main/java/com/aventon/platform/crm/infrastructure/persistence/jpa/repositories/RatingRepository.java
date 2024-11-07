package com.aventon.platform.crm.infrastructure.persistence.jpa.repositories;

import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.shared.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Rating Repository
 * @summary
 * This interface represents the rating repository
 * @author Gonzalo Quedena
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    /**
     * Exists By Email Address And ProductId And Rating Aspect
     * @summary
     * This method checks if a rating exists by email address, product id and rating aspect
     * @param emailAddress the email address
     * @param productId the product id
     * @param ratingAspect the rating aspect
     * @return true if the rating exists, false otherwise
     */
    boolean existsByEmailAddressAndProductIdAndRatingAspect(EmailAddress emailAddress,
                                                            ProductId productId, RatingAspect ratingAspect);
}
