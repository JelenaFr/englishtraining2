package ee.team3.englishtraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String index(Model model) {


        return "index";
    }
    @PostMapping
    public String toLanguage(Model model) {

        return "saved";
    }

}
