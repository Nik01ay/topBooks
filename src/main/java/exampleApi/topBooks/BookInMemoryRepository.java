package exampleApi.topBooks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class BookInMemoryRepository {

    @Getter
    private final List<Book> books;

    public List<Book> getBookByYear(Integer year) {

        List<Book> result = new ArrayList<>();
        result.addAll(books.stream().
                filter(book ->
                        {
                            if (book.publicationDate()!=null) {
                                return book.publicationDate().contains(Integer.toString(year));
                            } else return false;
                        }
                ).toList());

    return result;
    }

}
