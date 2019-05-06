package nl.first8.generativetesting.rest;

import java.time.LocalDate;

import lombok.Value;
import nl.first8.generativetesting.Author;
import nl.first8.generativetesting.Book;
import nl.first8.generativetesting.Publisher;

/**
 * Model to generate JSON from.
 */
@Value
public final class BookResource {
    /**
     * Title of the book.
     */
	private final String title;
    /**
     * Name of the author.
     */
	private final String author;
    /**
     * Name of the publisher.
     */
	private final String publisher;
    /**
     * Date of publication.
     */
	private final LocalDate publishedOn;
	
	/**
	 * @return a book based on this resource
	 */
	public Book toBook() {
		final Author bookAuthor = new Author(author);
		final Publisher bookPublisher = new Publisher(publisher);
		return new Book(title, bookAuthor, bookPublisher, publishedOn);
	}
	
	/**
	 * @param book to base the resource on
	 * @return a resource based on the book
	 */
	public static BookResource fromBook(final Book book) {
		return new BookResource(
				book.getTitle(), //
				book.getAuthor().getName(), //
				book.getPublisher().getName(), //
				book.getPublishedOn());
	}
}
