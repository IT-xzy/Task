package com.ev.controller;

import com.ev.entity.Occupation;
import com.ev.service.OccupationService;
import com.ev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/u")
public class PrivatePagesController {

    @Autowired
    private OccupationService occupationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/occupation", method = RequestMethod.GET)
    public String getOccupation(Model model) throws Exception {
        List<Occupation> occupations = occupationService.selectOccupation();
        model.addAttribute("occupations", occupations);
        return "occupation";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable(value = "name") String name, Model model) throws Exception {
        model.addAttribute("user", userService.findUser(name));
        return "user";
    }
}
