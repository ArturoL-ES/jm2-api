package com.arturo.jm2api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired private UserService userService;
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User get(@PathVariable String username) {
        return userService.findUser(username);    
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable String username) {
        return userService.deleteUser(username);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public User save(@ModelAttribute User user) {
        return userService.saveUser(user);    
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User update(@ModelAttribute User user) {
        return userService.updateUser(user);    
    }
    
}
