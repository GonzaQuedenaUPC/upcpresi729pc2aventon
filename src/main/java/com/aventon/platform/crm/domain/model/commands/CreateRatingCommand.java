package com.aventon.platform.crm.domain.model.commands;

public record CreateRatingCommand(Long productId, String userEmailAddress,
                                  Integer rating, String ratingAspect, String comment) {

    public CreateRatingCommand {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
