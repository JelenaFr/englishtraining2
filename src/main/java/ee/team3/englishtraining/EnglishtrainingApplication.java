package ee.team3.englishtraining;

import ee.team3.englishtraining.model.ComplexityLevel;
import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

import static ee.team3.englishtraining.model.ComplexityLevel.*;

@SpringBootApplication
public class EnglishtrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglishtrainingApplication.class, args);
    }

//    public EnglishtrainingApplication() {
//        super();
//    }


    @Bean
    CommandLineRunner runner (WordRepo repository){
        Word w1 = new Word();
        Word w2 = new Word();
        Word w3 = new Word();
        w1.setComplexityLevel(EASY);
        w2.setComplexityLevel(MEDIUM);
        w3.setComplexityLevel(HARD);
        return args -> {

            repository.save(new Word("table","laud","стол", w1.getComplexityLevel()) );
            repository.save(new Word("name","nimi","имя", w2.getComplexityLevel()));
            repository.save(new Word("weather","ilm","погода", w3.getComplexityLevel()));
        };
    }

}
