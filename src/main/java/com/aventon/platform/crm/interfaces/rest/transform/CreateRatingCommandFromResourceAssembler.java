package com.aventon.platform.crm.interfaces.rest.transform;

import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.interfaces.rest.resources.CreateRatingResource;

/**
 * Create Rating Command From Resource Assembler
 * @summary
 * This class assembles the create rating command from the resource
 * @author Gonzalo Quedena
 */
public class CreateRatingCommandFromResourceAssembler {

    /**
     * To Command From Resource
     * @summary
     * This method assembles the create rating command from the resource and the product id
     * @param resource the create rating resource
     * @param productId the product id
     * @return the create rating command assembled from the resource
     */
    public static CreateRatingCommand toCommandFromResource(CreateRatingResource resource, Long productId) {
        return new CreateRatingCommand(
                productId,
                resource.userEmailAddress(),
                resource.rating(),
                resource.ratingAspect(),
                resource.comment()
        );
    }
}
