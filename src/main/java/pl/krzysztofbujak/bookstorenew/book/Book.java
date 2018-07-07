package pl.krzysztofbujak.bookstorenew.book;

import lombok.*;
import pl.krzysztofbujak.bookstorenew.author.Author;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String isbn;
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;
    private double price;

    public Book(String isdn, String title, Set<Author> authors, double price){
        this.isbn = isdn;
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

}
