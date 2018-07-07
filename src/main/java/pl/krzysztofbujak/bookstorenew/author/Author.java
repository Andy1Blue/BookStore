package pl.krzysztofbujak.bookstorenew.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.krzysztofbujak.bookstorenew.book.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;

//    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

}
