package edu.oakland.csi3450.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.oakland.csi3450.service.IDB;
import java.util.List;

@Controller
public class ViewController {
    @Autowired IDB db;

    @RequestMapping("/customer")
    public String customer(Model model) {
        return "customer";
    }

    @RequestMapping("/payment")
    public String payment(Model model){
        return "payment";
    }
  
    @RequestMapping("/admin")
    public String admin(Model model) {
        List<String> names = db.getTableNames();
        model.addAttribute("names", names);
        return "admin";
    }
}
