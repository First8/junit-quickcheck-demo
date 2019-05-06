package nl.first8.generativetesting;

import lombok.Value;

/**
 * Writer of a book.
 */
@Value
public final class Author {
    /**
     * Name of the writer.
     */
	private final String name;
}
