package pl.krzysztofbujak.bookstorenew.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    private String isbn;
    private String title;
    private String authors;
    private String price;
}
