package com.aventon.platform.crm.domain.model.aggregates;

import com.aventon.platform.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.aventon.platform.shared.domain.model.valueobjects.EmailAddress;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

/***
 * Rating Aggregate Root
 * @summary
 * This class represents the rating aggregate root
 * @author Gonzalo Quedena
 */
@Entity
public class Rating extends AuditableAbstractAggregateRoot<Rating> {

    /***
     * productId
     * @summary
     * The product id value object
     */
    @Embedded
    private ProductId productId;

    /***
     * emailAddress
     * @summary
     * The email address value object
     */
    @Embedded
    private EmailAddress emailAddress;

    /***
     * rating
     * @summary
     * The rating value
     */
    @Getter
    @Min(1)
    @Max(5)
    @NotNull
    private Integer rating;

    /**
     * ratingAspect
     * @summary
     * The rating aspect value object
     */
    @Getter
    @NotNull
    private RatingAspect ratingAspect;

    /***
     * comment
     * @summary
     * The comment value
     */
    @Getter
    @Size(max=360)
    private String comment;

    /**
     * ratedAt
     * @summary
     * The date the rating was created
     */
    @Getter
    private Date ratedAt;

    /**
     * Constructor
     */
    public Rating() {
    }

    /**
     * Constructor
     * @summary
     * This constructor creates a rating aggregate root from a create rating command
     * @param command the create rating command
     */
    public Rating(CreateRatingCommand command) {
        this.productId = new ProductId(command.productId());
        this.emailAddress = new EmailAddress(command.userEmailAddress());
        this.rating = command.rating();
        this.ratingAspect = RatingAspect.valueOf(command.ratingAspect());
        this.comment = command.comment();
        this.ratedAt = new Date();
    }

    /**
     * getProductId
     * @return the product id
     */
    public Long getProductId() {
        return this.productId.productId();
    }

    /**
     * getEmailAddress
     * @return the email address
     */
    public String getEmailAddress() {
        return this.emailAddress.emailAddress();
    }
}
