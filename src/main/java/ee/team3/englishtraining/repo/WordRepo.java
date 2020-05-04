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

	List<Word> findByComplexity(@Param("complexity") Complexity complexity);
	List<Word> findByComplexityAndLanguage(@Param("complexity") Complexity complexity, @Param ("language")Word word);

}
