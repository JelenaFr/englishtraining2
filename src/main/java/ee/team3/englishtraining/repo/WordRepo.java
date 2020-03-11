package ee.team3.englishtraining.repo;

import ee.team3.englishtraining.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {

    @Query(value = "SELECT in_english FROM words ORDER BY RAND() LIMIT 1", nativeQuery = true)
    String findRandomEnglishWord();


}
