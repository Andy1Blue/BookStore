package pl.krzysztofbujak.bookstorenew.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("books")
    public Collection<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        BookMapper mapper = new BookMapper();
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book b : books) {
            BookDto bookDto = mapper.map(b);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @RequestMapping(value = "books", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("books/{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn) {
        List<Book> books = bookRepository.findByIsbn(isbn);

        books = bookRepository.findByIsbn(isbn);

        if (books.size() > 1) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            for (Book b : books) {
                bookRepository.delete(b);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("books/{isbn}")
    @ResponseBody
    public ResponseEntity<Book> updateBookPrice(@PathVariable String isbn,
                                                @RequestParam("price") double price) {
        List<Book> books = bookRepository.findByIsbn(isbn);

        if (!books.isEmpty()) {
            for (Book b : books) {
              //  Book book = new Book(b.getIsbn(), b.getTitle(), b.getAuthors(), price);
            }
            bookRepository.updatePrice(isbn,price);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("books/{title}")
    public Collection<BookDto> getBookByTitle(@PathVariable String title) {
        List<Book> books = bookRepository.findByTitle(title);
        BookMapper bookMapper = new BookMapper();
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book b: books) {
            BookDto bookDto = bookMapper.map(b);
            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

}
