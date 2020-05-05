package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.controller.forms.UserSelectionForm;
import ee.team3.englishtraining.controller.forms.UserTranslationForm;
import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    private WordRepo wordRepo;


//	ArrayList<String> userLanguages = new ArrayList<>();

    @GetMapping("/start")
    public String startPage(Model model) {
        model.addAttribute("words", wordRepo.findAll());
        return "start";
    }


    @GetMapping("/start/{id}/delete")
    public String showById(@PathVariable("id") Long wordId) {
        wordRepo.deleteById(wordId);
        return "redirect:/start";
    }

    @GetMapping(value = "/start/addword")
    public String index(Model model) {
        model.addAttribute("newword", new Word());
        return "addword";
    }

    @PostMapping("/start/addword")
    public String addBookform(Word word, Model model) {
        model.addAttribute("newword", new Word());
        wordRepo.save(word);
        return "redirect:/start";

    }

    @GetMapping("/start/{id}/edit")
    public String editFormById(@PathVariable("id") Long wordId, Model model) {
        if (wordRepo.findById(wordId).isPresent()) {
            model.addAttribute("word", wordRepo.findById(wordId).get());
        } else {
            model.addAttribute("word", new Word());
        }
        return "edit";
    }

    @PostMapping("start/edit/{id}")
    public String updateBook(@PathVariable("id") Long wordId, Word word) {
        Word fixingword = wordRepo.findById(wordId).get();
        wordRepo.save(word);
        return "redirect:/start/";
    }

    @GetMapping("/")
    public String welcomepage(Model model) {
        model.addAttribute("userSelectionForm", new UserSelectionForm());
        return "optionpage";
    }

    @PostMapping("/optionpage")
    public String userSelection(Model model, @ModelAttribute("userSelectionForm") UserSelectionForm selection) {
        List<Word> words = wordRepo.findByComplexity(selection.getComplexity());
        UserTranslationForm form = new UserTranslationForm();
        form.setWords(words);
        form.setFromLanguage(selection.getFromLanguage());
        form.setToLanguage(selection.getToLanguage());

        model.addAttribute("translationForm", form);


        return "trainingpage";
    }

    @PostMapping("/trainingpage")
    public String userTranslations(Model model, @ModelAttribute("translationForm") UserTranslationForm translationForm) {
        List<Word> words = translationForm.getWords();
        List<Word> correctTranslations = new ArrayList<>();
        if (translationForm.getToLanguage() == "inEnglish") {
            correctTranslations = words.stream()
                    .filter(word -> word.getInEnglish().equals(word.getTranslation()))
                    .collect(Collectors.toList());
        }
        if (translationForm.getToLanguage() == "inEstonian") {
            correctTranslations = words.stream()
                    .filter(word -> word.getInEstonian().equals(word.getTranslation()))
                    .collect(Collectors.toList());
        }
        if (translationForm.getToLanguage() == "inRussian") {
            correctTranslations = words.stream()
                    .filter(word -> word.getInRussian().equals(word.getTranslation()))
                    .collect(Collectors.toList());
        }

        words.removeAll(correctTranslations);

        model.addAttribute("correctTranslations", correctTranslations);
        model.addAttribute("wrongTranslations", words);

        return "resultpage";
    }


}
