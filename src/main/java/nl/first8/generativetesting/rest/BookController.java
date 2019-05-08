package nl.first8.generativetesting.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nl.first8.generativetesting.BookService;

/**
 * Controller to serve books through REST.
 */
@RestController
@AllArgsConstructor
public final class BookController {
    /**
     * To query for books.
     */
    private final BookService bookService;

    /**
     * @return all books
     */
    @GetMapping("books")
    public List<BookResource> books() {
        return bookService.findAll().stream() //
                .map(BookResource::fromBook) //
                .collect(Collectors.toList());
    }
}
