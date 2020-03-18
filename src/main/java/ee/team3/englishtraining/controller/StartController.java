package ee.team3.englishtraining.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;

@Controller
@RequestMapping
public class StartController {
	@Autowired
	private WordRepo wordRepo;

	@GetMapping("/start")
	public String startPage(Model model) {
		model.addAttribute("words", wordRepo.findAll());
		return "start";
	}

	@GetMapping("/welcomepage")
	public String welcomepage(Model model) {
		model.addAttribute("userSelectionForm", new UserSelectionForm());
		return "welcomepage";
	}

	@PostMapping("/welcomepage")
	public String userSelection(Model model, @ModelAttribute("userSelectionForm") UserSelectionForm selection) {
		List<Word> words = wordRepo.findByComplexity(selection.getComplexity());
		UserTranslationForm form = new UserTranslationForm();
		form.setWords(words);
		model.addAttribute("translationForm", form);

		return "trainingpage";
	}

	@PostMapping("/trainingpage")
	public String userTranslations(Model model, @ModelAttribute("translationForm") UserTranslationForm translationForm) {
		List<Word> words = translationForm.getWords();
		List<Word> correctTranslations = words.stream()
				.filter(word-> word.getInEnglish().equals(word.getTranslation()))
				.collect(Collectors.toList());
		
		words.removeAll(correctTranslations);

		model.addAttribute("correctTranslations", correctTranslations);
		model.addAttribute("wrongTranslations", words);

		
		return "resultpage";
	}

}
