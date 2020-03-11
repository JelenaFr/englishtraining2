package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import ee.team3.englishtraining.service.QueryToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Statement;
import java.util.Collection;

@Controller
@RequestMapping("/start")
public class StartController {
    @Autowired
    WordRepo wordRepo;


    @GetMapping
    public String startPage(Model model) {

        model.addAttribute("words", wordRepo.findAll());
        return "start";
    }

    @GetMapping("/trainingpage")
    public String getSomeInglishWord(Model model) {
        System.out.println(wordRepo.findRandomEnglishWord());
        model.addAttribute("someword", wordRepo.findRandomEnglishWord());


        return "trainingpage";
    }


}
