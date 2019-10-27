package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/selectUser")
    @ResponseBody
    public User selectUser(int id){
        User user = userService.selectUser(id);
        return user;
    }

    @RequestMapping("/updateUser")
    public String updateUser(String name,int id) throws Exception {
        boolean b = userService.updateUser(name, id);
        if(b){
            return "success";
        }else{
            return "failed";
        }
    }

}
