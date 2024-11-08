package com.aventon.platform.crm.application.internal;

import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.crm.domain.services.RatingCommandService;
import com.aventon.platform.crm.infrastructure.persistence.jpa.repositories.RatingRepository;
import com.aventon.platform.shared.domain.model.valueobjects.EmailAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Rating Command Service Implementation
 * @summary
 * This class implements the rating command service
 * @author Gonzalo Quedena
 */
@Service
public class RatingCommandServiceImpl implements RatingCommandService {

    /**
     * Rating Repository
     */
    private final RatingRepository ratingRepository;

    /**
     * Constructor
     * @summary
     * The constructor initializes the rating repository
     * @param ratingRepository the rating repository
     */
    public RatingCommandServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    /**
     * Handle Create Rating Command
     * @summary
     * This method handles the create rating command
     * @param command the create rating command
     * @return the optional rating
     */
    @Override
    public Optional<Rating> handle(CreateRatingCommand command) {

        var emailAddress = new EmailAddress(command.userEmailAddress());
        var productId = new ProductId(command.productId());

        if (ratingRepository.existsByEmailAddressAndProductIdAndRatingAspect(
                emailAddress, productId, RatingAspect.valueOf(command.ratingAspect()))) {

            throw new IllegalArgumentException("Rating already exists");
        }

        var rating = new Rating(command);
        ratingRepository.save(rating);

        return Optional.of(rating);
    }
}
