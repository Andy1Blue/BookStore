package pl.krzysztofbujak.bookstorenew.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDto implements Serializable {

    private String name;
    private String lastname;
    private String books;

}
