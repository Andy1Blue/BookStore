package pl.krzysztofbujak.bookstorenew.author;

import pl.krzysztofbujak.bookstorenew.book.Book;
import pl.krzysztofbujak.bookstorenew.common.Mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorMapper implements Mapper<Author, AuthorDto> {


    @Override
    public AuthorDto map(Author author) {
        String books = author.getBooks()
                .stream()
                .map(BookToString.INSTANCE)
                .collect(Collectors.joining(", "));
        return new AuthorDto(author.getName(), author.getLastname(), books);
    }

    private enum BookToString implements Function<Book, String> {
        INSTANCE;

        @Override
        public String apply(Book book) {
            return book.getTitle();
        }
    }

}
