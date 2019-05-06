package nl.first8.generativetesting;

import java.time.LocalDate;

import lombok.Value;

/**
 * A published book.
 */
@Value
public final class Book {
    /**
     * Title of the book.
     */
    private final String title;
    /**
     * Writer of the book.
     */
    private final Author author;
    /**
     * Organization that printed and distributed the book.
     */
    private final Publisher publisher;
    /**
     * Publication date.
     */
    private final LocalDate publishedOn;
}