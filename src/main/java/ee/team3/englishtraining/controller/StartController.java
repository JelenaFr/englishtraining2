package ee.team3.englishtraining.controller;

import ee.team3.englishtraining.model.Complexity;
import ee.team3.englishtraining.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping ("/trainingpage")
    public void getUserOptions(){};

    static String myWord;

    @GetMapping("/trainingpage")
    public String getSomeInglishWord(Model model) {
    myWord= wordRepo.findRandomEnglishWord(Complexity.HARD).get(0).getInEnglish();
       //model.addAttribute("anyword", myWord );
       model.addAttribute( "wordfromrepo", wordRepo.findRandomEnglishWord(Complexity.EASY) );
//       checkInputWord(myWord);
       //model.addAttribute("anotherword", myWord );
        return "trainingpage";
    }


//    @GetMapping("/trainingpage")
//    public String checkInputWord(Model model){
////        getSomeInglishWord(String myWord){};
//
//        return "trainingpage";
//    }


//
//        model.addAttribute("sameword", myWord );
//        return "trainingpage";
//    }

//    @PostMapping("/trainingpage")
//    public String checkToWords(@ModelAttribute("anyword") Word checkWord) {
//
//        System.out.println(checkWord.getWordId());
//
//        return "trainingpage";
//    }


}
