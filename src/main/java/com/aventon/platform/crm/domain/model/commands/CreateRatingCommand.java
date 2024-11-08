package com.aventon.platform.crm.domain.model.commands;

/**
 * Create Rating Command
 * @summary
 * This class represents the create rating command
 * @param productId the product id
 * @param userEmailAddress the user email address
 * @param rating the rating
 * @param ratingAspect the rating aspect
 * @param comment the comment
 */
public record CreateRatingCommand(Long productId, String userEmailAddress,
                                  Integer rating, String ratingAspect, String comment) {

    /**
     * Constructor
     * @summary
     * The constructor validates the rating to ensure it is between 1 and 5
     * @param productId the product id
     * @param userEmailAddress the user email address
     * @param rating the rating
     * @param ratingAspect the rating aspect
     * @param comment the comment
     */
    public CreateRatingCommand {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
