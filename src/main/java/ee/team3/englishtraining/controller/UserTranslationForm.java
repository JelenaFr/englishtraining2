package ee.team3.englishtraining.controller;

import java.util.List;

import ee.team3.englishtraining.model.Word;
import lombok.Data;

@Data
public class UserTranslationForm {
	private List<Word> words;
}
