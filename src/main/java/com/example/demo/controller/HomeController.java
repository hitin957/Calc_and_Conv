package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping("/home")
    String getHome(Model model){
        String a = "Tom";
        model.addAttribute("name", a);
        return "home";
    }

    @GetMapping("/Call")
    public String calc(){
        return "Call";
    }

    @GetMapping("/Converter")
    public String convGet(){
        return "Converter";
    }

    @PostMapping("/Converter")
    public String convPost(Model model, @RequestParam(name = "Number", defaultValue = "0") double Number,
                                        @RequestParam(name = "Valute") String Valute){
        if (Valute.equals("Рубли,Рубли") || Valute.equals("Тенге,Тенге") || Valute.equals("Лира,Лира"))//3
            model.addAttribute("act", Number*1);
        if (Valute.equals("Рубли,Тенге"))//4
            model.addAttribute("act", Number*5.35);
        if (Valute.equals("Тенге,Рубли"))//5
            model.addAttribute("act", Number*0.186868);
        if (Valute.equals("Рубли,Лира"))//6
            model.addAttribute("act", Number*0.37726);
        if (Valute.equals("Тенге,Лира"))//7
            model.addAttribute("act", Number*0.07022);
        if (Valute.equals("Лира,Рубли"))//8
            model.addAttribute("act", Number*2.65);
        if (Valute.equals("Лира,Тенге"))//9
            model.addAttribute("act", Number*14.24);
        return "Converter";
    }

    @PostMapping("/Answer")//Ответ после математического действия
    public String setAnswer_1(Model model, @RequestParam(name = "Num_1", defaultValue = "0") double Num_1,
                                           @RequestParam(name = "Num_2", defaultValue = "0") double Num_2,
                                           @RequestParam(name = "action") String action){
        if (action.equals("+"))
            model.addAttribute("Ansver", Num_1+Num_2);
        if (action.equals("-"))
            model.addAttribute("Ansver", Num_1-Num_2);
        if (action.equals("*"))
            model.addAttribute("Ansver", Num_1*Num_2);
        if (action.equals("/"))
            model.addAttribute("Ansver", Num_1/Num_2);
        return "Answer";
    }
}
