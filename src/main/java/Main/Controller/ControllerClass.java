package Main.Controller;

import Main.Service.Visitors;
import Main.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerClass {

    @PostMapping("/")
    public Object uniqueVisitors (@RequestParam (value = "path") String path) {
        List<User> userList = Visitors.readFileRetVi(path);
        if (userList != null)
            return userList;
        return "Either were there no visitors or the given file path is incorrect";
    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome! Please insert the file path as a parameter and initiate a post request";
    }
}
