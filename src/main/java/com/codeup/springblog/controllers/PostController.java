package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnIndividualPosts(@PathVariable long id, Model model){
        model.addAttribute("singlePost", postDao.getById(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String returnPostsForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name="title") String title,
            @RequestParam(name="body") String body){
        try {
            Post newPost = new Post(title, body);
            postDao.save(newPost);
            return "redirect:/posts";
        }catch(Exception e){
            throw new RuntimeException("Error adding new post to postDao");
        }
    }





}
