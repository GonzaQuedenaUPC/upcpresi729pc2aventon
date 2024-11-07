package com.aventon.platform.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * ProductId value object
 * @summary
 * This class represents the value object for the product id
 * @param id the product id
 * @author Gonzlao Quedena
 */
@Embeddable
public record ProductId(Long id) {

    /**
     * Constructor
     * @summary
     * The constructor validates the product id to ensure it is not null or empty
     * @param id the product id
     */
    public ProductId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid product id");
        }
    }
}
