package com.ecommerce.payment.error;

/**
 * Exception thrown when a requested customer cannot be found in the system.
 *
 * <p>This checked exception indicates that an operation expected an existing
 * customer record but none was found for the provided identifier. Controllers
 * or service callers should translate this exception into an appropriate
 * client response (for example HTTP 404 Not Found).</p>
 */
public class CustomerNotFound extends Exception {

    /**
     * Constructs a new {@code CustomerNotFound} exception with the specified detail message.
     *
     * @param errorMessage the detail message explaining why the customer was not found
     */
    public CustomerNotFound(String errorMessage) {
        super(errorMessage);
    }
}
