package exampleApi.topBooks.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UniversalError> catchBadRequestParamException(BadRequestException e){
        return new ResponseEntity<>(
                new UniversalError(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<UniversalError> handleMissingParams(MissingServletRequestParameterException ex) {
        String errorMessage = "Required parameter '" + ex.getParameterName() + "' is missing";
        return new ResponseEntity<>(
                new UniversalError(HttpStatus.BAD_REQUEST.value(), errorMessage), HttpStatus.BAD_REQUEST);
    }
}


