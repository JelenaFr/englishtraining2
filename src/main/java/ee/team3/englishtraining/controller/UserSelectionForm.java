package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.model.Complexity;
import lombok.Data;

@Data
public class UserSelectionForm {

	private Complexity complexity;
	private String language;
}