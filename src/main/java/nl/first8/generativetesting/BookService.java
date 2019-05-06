package nl.first8.generativetesting;

import java.util.List;

/**
 * Gets books.
 */
public interface BookService {
    /**
     * @return all books
     */
	List<Book> findAll();
}
