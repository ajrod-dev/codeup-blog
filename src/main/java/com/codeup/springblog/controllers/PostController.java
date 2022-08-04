package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {

    @GetMapping("/posts")
    public String returnPosts(Model model){
        List<Post> allPosts = new ArrayList<Post>();
        allPosts.add(new Post("First Post", "Hello World"));
        allPosts.add(new Post("Second Post", "Learning Spring"));
        allPosts.add(new Post("Third Post", "And ThymeLeaf."));
        model.addAttribute("posts", allPosts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnIndividualPosts(@PathVariable int id, Model model){
        model.addAttribute("singlePost", new Post("4th Post", "I forgot to add Hibernate to list of things."));
        return "/posts/show";
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
