package com.aventon.platform.crm.interfaces.rest.transform;

import com.aventon.platform.crm.domain.model.aggregates.Rating;
import com.aventon.platform.crm.interfaces.rest.resources.RatingResource;

/**
 * Rating Resource From Entity Assembler
 * @summary
 * This class is responsible for assembling the rating resource from the entity
 * @author Gonzalo Quedena
 */
public class RatingResourceFromEntityAssembler {

    /**
     * Assemble the rating resource from the entity
     * @param rating the rating entity
     * @return the rating resource assembled from the entity
     */
    public static RatingResource toResourceFromEntity(Rating rating) {
        return new RatingResource(
                rating.getId(),
                rating.getProductId(),
                rating.getEmailAddress(),
                rating.getRating(),
                rating.getRatingAspect().name(),
                rating.getComment(),
                rating.getRatedAt()
        );
    }
}
