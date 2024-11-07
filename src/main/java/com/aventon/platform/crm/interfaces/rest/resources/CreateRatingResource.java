package com.aventon.platform.crm.interfaces.rest.resources;

/**
 * Create Rating Resource
 * @summary
 * Represents the create rating resource.
 * @param userEmailAddress the user email address
 * @param rating the rating
 * @param ratingAspect the rating aspect
 * @param comment the comment
 * @author Gonzalo Quedena
 */
public record CreateRatingResource(String userEmailAddress, Integer rating, String ratingAspect, String comment) {
}
