package nl.first8.generativetesting;

import lombok.Value;

/**
 * Organization that publishes books.
 */
@Value
public final class Publisher {
    /**
     * Name of the publisher.
     */
	private final String name;
}
