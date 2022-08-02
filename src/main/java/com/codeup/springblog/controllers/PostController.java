package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    @GetMapping("/posts")
    public String returnPosts(){
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnIndividualPosts(@PathVariable int id){
        return "/posts/view";
    }

    @GetMapping("/posts/create")
    public String returnPostsForm(){
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(){
        return null;
    }





}
