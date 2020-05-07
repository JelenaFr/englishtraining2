package ee.team3.englishtraining;

import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

import static ee.team3.englishtraining.model.Complexity.EASY;
import static ee.team3.englishtraining.model.Complexity.MEDIUM;
import static ee.team3.englishtraining.model.Complexity.HARD;



@SpringBootApplication()
public class EnglishtrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglishtrainingApplication.class, args);
    }



    @Bean
    CommandLineRunner runner (WordRepo repository){

        return args -> {

            repository.save(new Word("table","laud","стол", EASY) );
            repository.save(new Word("name","nimi","имя", EASY));
            repository.save(new Word("weather","ilm","погода", EASY));
            repository.save(new Word("building","hoone","здание", MEDIUM));
            repository.save(new Word("action","tegevus","действие", MEDIUM));
            repository.save(new Word("attempt","katse","попытка", MEDIUM));
            repository.save(new Word("inseparable","lahutamatu","неотделимый",HARD));
            repository.save(new Word("requirements","nõuded","требования", HARD));
            repository.save(new Word("vendor","tarnija","продавец", HARD));
        };
    }

}
