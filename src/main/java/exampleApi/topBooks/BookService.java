package exampleApi.topBooks;

import exampleApi.topBooks.Errors.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookInMemoryRepository books;

    public List<Book> getBookByYear(Integer year) {
        if((year==null) || (year == 0)) {
            return books.getBooks();
        }
        return books.getBookByYear(year);
    }

    public List<Book> getTopCountInYearColmnSort(Integer count, Integer year, String column, String sort) {
        List<Book> books = null;

            if (sort.equalsIgnoreCase("ASC") | sort.equalsIgnoreCase("DESC") ){
                SortDirecton s = sort.equalsIgnoreCase("ASC") ? SortDirecton.ASC : SortDirecton.DESC;
                books = SortingUtil.sortBooksByField(getBookByYear(year), column, s).stream().limit(count).toList();
            } else throw new BadRequestException("Invalid sort direction, actual ASC or DESC");

        return books;
    }
}
