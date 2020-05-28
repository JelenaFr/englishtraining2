package ee.team3.englishtraining.controller.forms;

import ee.team3.englishtraining.model.Complexity;
import lombok.Data;

@Data
public class UserSelectionForm {

	private Complexity complexity = Complexity.EASY;
	private String fromLanguage;
	private String toLanguage;
}
