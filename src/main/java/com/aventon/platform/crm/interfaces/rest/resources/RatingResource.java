package com.aventon.platform.crm.interfaces.rest.resources;

import java.util.Date;

/**
 * Rating Resource
 * @summary
 * This class represents the rating resource
 * @param id the rating id
 * @param productId the product id
 * @param userEmailAddress the user email address
 * @param rating the rating
 * @param ratingAspect the rating aspect
 * @param comment the comment
 * @param ratedAt the rated at date
 * @author Gonzalo Quedena
 */
public record RatingResource(Long id, Long productId, String userEmailAddress,
                             Integer rating, String ratingAspect, String comment, Date ratedAt) {
}
