package exampleApi.topBooks;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;


@RequiredArgsConstructor
public class CvsBookMapper {

    @SneakyThrows
    public static List<Book> cvsToHashMap(Path filename) {

        Reader myReader = new FileReader(filename.toString());
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Book.class)
                .withColumnSeparator(',').withSkipFirstDataRow(true)
                .withNullValue("")
                .withQuoteChar('\"');

        MappingIterator<Book> iterator = mapper
                .readerFor(Book.class)
                .with(schema)
                .readValues(myReader);

         List<Book> books = iterator.readAll();


        for (Book book : books) {
            System.out.println(book.toString());
        }

        return books;
    }

}

