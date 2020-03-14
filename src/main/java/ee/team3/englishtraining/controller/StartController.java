package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.model.Complexity;
import ee.team3.englishtraining.model.Word;
import ee.team3.englishtraining.repo.WordRepo;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("anyword", wordRepo.findRandomEnglishWord(Complexity.HARD).get(0));
        return "trainingpage";
    }

    @PostMapping("/trainingpage")
    public String checkToWords(@ModelAttribute("anyword") Word word) {

        System.out.println(word.getWordId());

        return "trainingpage";
    }


}
