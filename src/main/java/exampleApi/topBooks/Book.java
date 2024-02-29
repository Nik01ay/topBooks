package exampleApi.topBooks;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({"id", "isbn", "title", "seriesTitle", "seriesReleaseNumber", "authors",
        "publisher", "language", "description", "numPages", "format", "genres", "publicationDate",
        "ratingScore", "numRatings", "numReviews", "currentReaders", "wantToRead", "price", "url"})
//@RequiredArgsConstructor

public record Book (
        Integer id,
        String isbn,
        String title,
        String seriesTitle,
        String seriesReleaseNumber,
        String authors,
        String publisher,
        String language,
        String description,
        String numPages,
        String format,
        String genres,
        String publicationDate,
        String ratingScore,
        String numRatings,
        String numReviews,
        String currentReaders,
        String wantToRead,
        String price,
        String url

){}

