package exampleApi.topBooks.configuration;
import exampleApi.topBooks.BookInMemoryRepository;
import exampleApi.topBooks.CvsBookMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.nio.file.Path;

@Configuration
public class AppConfiguration {

    @Value("${spring.csv.import.locations}")
    private Path uploadPath;

    @Bean
    BookInMemoryRepository bookInMemoryRepository () {
        return new BookInMemoryRepository(CvsBookMapper.cvsToHashMap(uploadPath));
    }

}
