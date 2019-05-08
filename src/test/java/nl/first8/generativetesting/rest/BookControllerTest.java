package nl.first8.generativetesting.rest;

import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.google.common.collect.Streams;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import nl.first8.generativetesting.Book;
import nl.first8.generativetesting.BookService;
import nl.first8.generativetesting.rest.BookController;
import nl.first8.generativetesting.rest.BookResource;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(JUnitQuickcheck.class)
public final class BookControllerTest {
    /*
     * The usual Mockito mocks and rules
     */

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /*
     * Property based testing using mocks
     */

    /**
     * Tests the book controller against a mock book service, using
     * junit-quickcheck to generate test data.
     * 
     * @param resources generated by junit-quickcheck
     */
    @Property()
    public void testBasedOnResources(//
            final List<@From(Ctor.class) BookResource> resources) {

        // Given an mocked bookservice, which returns generated data when
        // findAll() is called.
        when(bookService.findAll()).thenReturn(resources.stream()
                .map(BookResource::toBook).collect(Collectors.toList()));

        // When we call books() on the book controller
        final List<BookResource> results = bookController.books();

        // We expect the book controller to return book resources which match
        // the books
        Streams //
                .zip(resources.stream(), results.stream(), Pair::of)//
                .forEach(pair -> {
                    final BookResource reference = pair.getLeft();
                    final BookResource result = pair.getRight();
                    assertThat( //
                            reference, //
                            SamePropertyValuesAs.samePropertyValuesAs(result));
                });
    }

    /**
     * Tests the book controller against a mock book service, using
     * junit-quickcheck to generate test data.
     * 
     * @param books generated by junit-quickcheck
     */
    @Property()
    public void testBasedOnBooks(//
            final List<
                    @From(BookResourceTest.BookGenerator.class) Book> books) {

        // Given an mocked bookservice, which returns generated data when
        // findAll() is called.
        when(bookService.findAll()).thenReturn(books);

        // When we call books() on the book controller
        final List<BookResource> resources = bookController.books();

        // We expect the book controller to return book resources which match
        // the books
        Streams //
                .zip(resources.stream(), books.stream(), Pair::of)//
                .forEach(pair -> {
                    final BookResource resource = pair.getLeft();
                    final Book book = pair.getRight();
                    assertThat( //
                            resource.toBook(), //
                            SamePropertyValuesAs.samePropertyValuesAs(book));
                });
    }
}
