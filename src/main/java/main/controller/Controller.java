package main.controller;

import main.dto.Request;
import main.exception.ApplicationException;
import main.model.User;
import main.service.Visitors;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @PostMapping("/")
    public List<User> findUniqueVisitors(@RequestBody @NotNull Request r){
        try {
            return Visitors.readFileRetVi(r.path);
        } catch (ApplicationException ex) {
            throw new ResponseStatusException(ex.getStatus(), ex.getMessage());
        } catch (Exception ex2) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
        }
    }
}
