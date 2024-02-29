package exampleApi.topBooks.Errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UniversalError {
    private int statusCode;
    private String message;

}

