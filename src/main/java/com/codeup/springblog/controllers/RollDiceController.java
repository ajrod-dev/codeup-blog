package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class RollDiceController {

    private int randNum;

    public int getRandNum(){
        return (int) Math.floor((Math.random() * 6) + 1);
    }

    @GetMapping("/roll-dice")
    public String rollDicePage(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessedNumber(@PathVariable int n, Model model){
        randNum = getRandNum();
        if(n == randNum){
            model.addAttribute("n", String.format("You guessed the correct number, %d", n));
        }else {
            model.addAttribute("n", String.format("The number rolled was %d, your guess was %d", randNum, n));
        }
        return "roll-dice";

    }

//    @PostMapping("/roll-dice/{n}")
//    public String guessedNum(@RequestParam (name="n") int n, Model model){
//        randNum = getRandNum();
//        if(n == randNum){
//          model.addAttribute("n", String.format("You guessed the correct number, %d", n));
//        }else {
//            model.addAttribute("n", String.format("The number rolled was %d, your guess was %d", randNum, n));
//        }
//        return "roll-dice";
//    }
}
