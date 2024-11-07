package com.aventon.platform.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * Email Address Value Object
 * @summary
 * This class represents the email address value object
 * @param emailAddress the email address
 * @author Gonzalo Quedena
 */
@Embeddable
public record EmailAddress(@Email @Size(max=50) String emailAddress) {

    /***
     * Constructor
     * @summary
     * The constructor validates the email address to ensure it is not null or empty
     * @param emailAddress the email address
     */
    public EmailAddress {
        if (emailAddress == null || emailAddress.isBlank()) {
            throw new IllegalArgumentException("Email address must not be null or empty");
        }
    }

}
