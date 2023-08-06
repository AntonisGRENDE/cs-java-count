package main.controller;

import main.dto.Request;
import main.service.Visitors;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Controller {

    @GetMapping("/")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
    @PostMapping("/")
    public Object findUniqueVisitors(@RequestBody @NotNull Request r){
        return Visitors.readFileReturnVisitors(r.path);
    }
}
