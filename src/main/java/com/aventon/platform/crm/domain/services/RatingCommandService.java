package com.aventon.platform.crm.domain.services;

import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;

import java.util.Optional;

/**
 * Rating Command Service
 * @summary
 * This interface represents the rating command service
 * @author Gonzalo Quedena
 */
public interface RatingCommandService {

    /**
     * Handle the command to create a rating
     * @param command the command to create a rating
     * @return An optional containing the rating created if the operation was successful, an empty optional otherwise
     */
    Optional<Rating> handle(CreateRatingCommand command);
}
