package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.model.ComplexityLevel;
import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Statement;
import java.util.*;

import static ee.team3.englishtraining.model.ComplexityLevel.HARD;

@Controller
@RequestMapping
public class StartController {
    @Autowired
    WordRepo wordRepo;


    @GetMapping("/start")
    public String startPage(Model model) {
        model.addAttribute("words", wordRepo.findAll());
        return "start";
    }
//    @GetMapping("/trainingpage")
//    public Map selectOptions(HttpServletRequest request)throws Exception{
//        Map refData = new HashMap();
//        List<ComplexityLevel>level = new ArrayList<>();
//        level.add()
//    };

    @GetMapping("/trainingpage")
    public String getSomeInglishWord(Model model) {
        model.addAttribute("anyword", wordRepo.findRandomEnglishMediumWord() );
        return "trainingpage";
    }
    @PostMapping("/trainingpage")
    public String checkToWords(@ModelAttribute("anyword") Word word){

        System.out.println(word.getWordId());

    return "trainingpage";}


}
