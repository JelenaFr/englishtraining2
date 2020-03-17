package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.model.Complexity;
import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    WordRepo wordRepo;
    @GetMapping(value = "/testpage")
    public String getTestPage(Model model){


        model.addAttribute("defaultName", "Peter Parker");
        model.addAttribute("greetings", "Hello Workd");
        model.addAttribute("wordfromrepo", wordRepo.findRandomEnglishWord(Complexity.EASY) );
//        model.addAttribute("estonianword", word.getInEstonian());
//        model.addAttribute("russianword", word.getInRussian());
        return "testpage";
    }

}
