package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class MyController{
    private final MyService service;

    MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/result")
    public String calculateChange(@RequestParam("change_cones") String s, @RequestParam("amount") int amount, Model model) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder s2 = new StringBuilder(s);
        if (s2.charAt(0) == '[' && s2.charAt(s2.length() - 1) == ']') {
            s2.deleteCharAt(0);
            s2.deleteCharAt(s2.length() - 1);
        }

        s = s2.toString();
        String[] massiv = s.split(",");

        for (String symbol : massiv) {
            list.add(Integer.parseInt(symbol.trim()));
        }

        ArrayList<Integer> list2 = service.changeMoney(list, amount);
        if(list2 == null) return "/index";
        model.addAttribute("coins", list2);
        return "result";
    }

}