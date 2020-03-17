package ee.team3.englishtraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String userSelections(@ModelAttribute("userSelectionForm") UserSelectionForm selection) {
		return "trainingpage";
	}

}
