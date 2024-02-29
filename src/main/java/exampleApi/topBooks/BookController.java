package exampleApi.topBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController  {
    private  final BookService bookService;
    @GetMapping("/top10")
    @ResponseStatus(HttpStatus.OK)
  //  http://localhost:8080/api/top10?year=2010&column=authors&sort=ASC
    public List<Book> getTop10(@RequestParam(required = false, name = "year", defaultValue = "0") Integer year,
                                @RequestParam(name = "column") String column,
                                @RequestParam(name = "sort") String sort){

            return bookService.getTopCountInYearColmnSort(10, year, column, sort);
    }
}
