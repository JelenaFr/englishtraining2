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

    @PostMapping ("/trainingpage")
    public void getUserOptions(){};

    static String myWord;

    @GetMapping("/trainingpage")
    public String getSomeInglishWord(Model model) {
    myWord= wordRepo.findRandomEnglishWord(Complexity.HARD).get(0).getInEnglish();
//        List<Word> listAllWords = wordRepo.findRandomEnglishWord(Complexity.HARD);
//        String myWord = listAllWords.get(0).getInEnglish();
//        List<Long> myWordIdList = wordRepo.findIdByword(myWord);
//        System.out.println(myWord);
//        System.out.println(myWordIdList.size());



        model.addAttribute("anyword", myWord );
        return "trainingpage";
    }

//    @PostMapping("/trainingpage")
//    public String checkToWords(@ModelAttribute("anyword") Word checkWord) {
//
//        System.out.println(checkWord.getWordId());
//
//        return "trainingpage";
//    }


}
