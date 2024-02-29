package exampleApi.topBooks;

import exampleApi.topBooks.Errors.BadRequestException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;




public class SortingUtil {
    public static List<Book> sortBooksByField(List<Book> books, String fieldName, SortDirecton sortDirection) {
        Comparator<Book> fieldComparator = Comparator.comparing(book -> {
            try {
                Object fieldValue = getBookField(book, fieldName);
                if (fieldValue == null) {
                    return "";
                } else {
                    return fieldValue.toString();
                }
            } catch (BadRequestException e) {
                throw new BadRequestException("Errors field - " + fieldName + " " + e.getMessage());
            }
        });

        if (sortDirection == SortDirecton.DESC) {
            fieldComparator = fieldComparator.reversed();
        }

        return books.stream()
                .filter(book -> {
                    try {
                        Object fieldValue = getBookField(book, fieldName);
                        return fieldValue != null && !fieldValue.equals("");
                    } catch (BadRequestException e) {
                        throw new BadRequestException("Errors field - " + fieldName + " " + e.getMessage());
                    }
                })
                .sorted(fieldComparator)
                .collect(Collectors.toList());
    }

    private static Object getBookField(Book book, String fieldName) {
        try {
            Field field = Book.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(book);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new BadRequestException("Invalid column value: " + fieldName + ". Actual: "
                    + Arrays.stream(Book.class.getDeclaredFields())
                    .map(Field::getName)
                    .filter(name -> !name.equals("id"))
                    .collect(Collectors.toList())
            );
        }
    }
}
