package ee.team3.englishtraining.repo;

import ee.team3.englishtraining.model.Complexity;
import ee.team3.englishtraining.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {

    @Query( "SELECT n FROM Word n where n.complexity = :complexity order by function('RAND') ")
    List<Word> findRandomEnglishWord(@Param("complexity")Complexity complexity);


            ;
//    @Query(value = "SELECT in_english FROM worddb.words where complexity_level ='MEDIUM' order by rand() limit 1;", nativeQuery = true)
//    String findRandomEnglishMediumWord();
//    @Query(value = "SELECT in_english FROM worddb.words where complexity_level ='EASY' order by rand() limit 1;", nativeQuery = true)
//    String findRandomEnglishEasyWord();
//    @Query(value = "SELECT in_russian FROM worddb.words where complexity_level ='HARD' order by rand() limit 1;", nativeQuery = true)
//    String findRandomRussianHardWord();
//    @Query(value = "SELECT in_russian FROM worddb.words where complexity_level ='MEDIUM' order by rand() limit 1;", nativeQuery = true)
//    String findRandomRussianMediumWord();
//    @Query(value = "SELECT in_russian FROM worddb.words where complexity_level ='EASY' order by rand() limit 1;", nativeQuery = true)
//    String findRandomRussianEasyWord();
//    @Query(value = "SELECT in_estonian FROM worddb.words where complexity_level ='HARD' order by rand() limit 1;", nativeQuery = true)
//    String findRandomEstonianHardWord();
//    @Query(value = "SELECT in_estonian FROM worddb.words where complexity_level ='MEDIUM' order by rand() limit 1;", nativeQuery = true)
//    String findRandomEstonianMediumWord();
//    @Query(value = "SELECT in_estonian FROM worddb.words where complexity_level ='EASY' order by rand() limit 1;", nativeQuery = true)
//    String findRandomEstonianEasyWord();





}
