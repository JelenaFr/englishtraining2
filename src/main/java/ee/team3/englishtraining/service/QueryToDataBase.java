package ee.team3.englishtraining.service;

import ee.team3.englishtraining.model.Word;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface QueryToDataBase {
    @Query("SELECT in_english FROM words ORDER BY RAND() LIMIT 1")
    Collection<Word> findRandomEnglishWord();
}
