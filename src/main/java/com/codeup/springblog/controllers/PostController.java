package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String returnPosts(){
        return String.format("<h2>Posts index page</h2>");
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String returnIndividualPosts(@PathVariable int id){
        return String.format("<h2>View an individual post with an id of %d</h2>", id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String returnPostsForm(){
        return String.format("<h2>View the form for creating a post</h2>");
    }



}
