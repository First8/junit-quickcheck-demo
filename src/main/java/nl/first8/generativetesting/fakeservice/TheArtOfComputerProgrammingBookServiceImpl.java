package nl.first8.generativetesting.fakeservice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.first8.generativetesting.Author;
import nl.first8.generativetesting.Book;
import nl.first8.generativetesting.BookService;
import nl.first8.generativetesting.Publisher;

/**
 * Finds a pre-defined list of books.
 */
@Component
public final class TheArtOfComputerProgrammingBookServiceImpl//
implements BookService {

	@Override
	public List<Book> findAll() {
		final Author author = new Author("Donald E. Knuth");
		final Publisher publisher = new Publisher("Addison-Wesley");
		
		return Arrays.asList(//
				new Book("Fundamental algorithms", author, publisher, //
						LocalDate.of(1968, 1, 1)), //
				new Book("Seminumerical algorithms", author, publisher, //
						LocalDate.of(1969, 1, 1)), //
				new Book("Sorting and searching", author, publisher, //
						LocalDate.of(1973, 1, 1)));
	}

}
