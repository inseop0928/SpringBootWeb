package com.jisweb.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/helloWorldTest")
    public String helloWorldTest(){
        return "jsp/test/helloWorld.jsp";
    }

    @RequestMapping("/helloWorld")
    public ModelAndView helloWorld(){
        ModelAndView modelAndView = new ModelAndView("jsp/test/helloWorld.jsp");

        modelAndView.addObject("name", "goddaehee");
        List<String> testList = new ArrayList<String>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        modelAndView.addObject("list", testList);

        return modelAndView;
    }


}
