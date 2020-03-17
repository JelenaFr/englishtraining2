package ee.team3.englishtraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping( "/" )
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }
    @RequestMapping( "/languages" )
    public String getLanguages(Model model) {
        model.addAttribute("title", "Languages Page");
        return "languages";
    }
//    @PostMapping
//    public String toLanguage(Model model) {
//
//        return "saved";
//    }
//
}
