package ee.team3.englishtraining.repo;

import ee.team3.englishtraining.model.ComplexityLevel;
import ee.team3.englishtraining.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {

//    согласна. Эта хуева туча методов - уродство. Но один параметризированный пока не получается написать

    @Query(value = "SELECT in_english FROM worddb.words where complexity_level ='HARD' order by rand() limit 1;", nativeQuery = true)
    String findRandomEnglishHardWord();
    @Query(value = "SELECT in_english FROM worddb.words where complexity_level ='MEDIUM' order by rand() limit 1;", nativeQuery = true)
    String findRandomEnglishMediumWord();
    @Query(value = "SELECT in_english FROM worddb.words where complexity_level ='EASY' order by rand() limit 1;", nativeQuery = true)
    String findRandomEnglishEasyWord();
    @Query(value = "SELECT in_russian FROM worddb.words where complexity_level ='HARD' order by rand() limit 1;", nativeQuery = true)
    String findRandomRussianHardWord();
    @Query(value = "SELECT in_russian FROM worddb.words where complexity_level ='MEDIUM' order by rand() limit 1;", nativeQuery = true)
    String findRandomRussianMediumWord();
    @Query(value = "SELECT in_russian FROM worddb.words where complexity_level ='EASY' order by rand() limit 1;", nativeQuery = true)
    String findRandomRussianEasyWord();
    @Query(value = "SELECT in_estonian FROM worddb.words where complexity_level ='HARD' order by rand() limit 1;", nativeQuery = true)
    String findRandomEstonianHardWord();
    @Query(value = "SELECT in_estonian FROM worddb.words where complexity_level ='MEDIUM' order by rand() limit 1;", nativeQuery = true)
    String findRandomEstonianMediumWord();
    @Query(value = "SELECT in_estonian FROM worddb.words where complexity_level ='EASY' order by rand() limit 1;", nativeQuery = true)
    String findRandomEstonianEasyWord();





}
