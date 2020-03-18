package ee.team3.englishtraining.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ee.team3.englishtraining.model.Complexity;
import ee.team3.englishtraining.model.Word;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {

	@Query("SELECT n FROM Word n where n.complexity = :complexity order by function('RAND') ")
	List<Word> findRandomEnglishWord(@Param("complexity") Complexity complexity);

	@Query("SELECT n FROM Word n where n.wordId  = :myWord")
	Long findIdByWord(@Param("myWord") String myWord);

//    @Query(value = "select id from worddb.words where in_english = 'table';", nativeQuery = true)
//    List<Long> findIdByword(String myWord);

	List<Word> findByComplexity(@Param("complexity") Complexity complexity);

}
