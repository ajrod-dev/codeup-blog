package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MathController {

    @GetMapping("/add/{num}/and/{num2}")
    @ResponseBody
    public String addTwoNums(@PathVariable int num, @PathVariable int num2){
        return String.format("<h2>The sum of %d and %d is: %d</h2>", num, num2, num + num2);
    }

    @GetMapping("/subtract/{num}/from/{num2}")
    @ResponseBody
    public String subtractTwoNums(@PathVariable int num, @PathVariable int num2){
        return String.format("<h2>The difference of %d from %d is: %d</h2>", num, num2, num2 - num);
    }

    @GetMapping("/multiply/{num}/and/{num2}")
    @ResponseBody
    public String multiplyTwoNums(@PathVariable int num, @PathVariable int num2){
        return String.format("<h2>The product of %d and %d is: %d</h2>", num, num2, num * num2);
    }

    @GetMapping("/divide/{num}/by/{num2}")
    @ResponseBody
    public String divideTwoNums(@PathVariable int num, @PathVariable int num2){
        return String.format("<h2>The quotient of %d by %d is: %d</h2>", num, num2, num / num2);
    }

}
