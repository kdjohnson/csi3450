package edu.oakland.csi3450.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @RequestMapping("/customer")
    public String customer(Model model) {
        return "customer";
    }

    @RequestMapping("/admin")
    public String customer(Model model) {
        return "admin"
    }
}
