package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "<h1>Hello from Spring.</h1>";
    }

    @RequestMapping(path="/hello/{name}", method= RequestMethod.GET)
    @ResponseBody
    public String helloName(@PathVariable String name){
        return String.format("Nice to meet you, %s!", name);
    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public String reportNumber(@PathVariable int num){
        String intro =  String.format("Here are some truths of the number %d.%n", num);
        String isEven = String.format("The  number %d  is even: %b.%n", num, num % 2 == 0);
        String numSquared = String.format("The number %d squared is %d.%n", num, (int)(Math.pow(num, 2)));
        return String.format("<h3>%s</h3><ul><li>%s</li><li>%s</li></ul>", intro, isEven, numSquared);
    }
}
