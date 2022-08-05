package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnIndividualPosts(@PathVariable long id, Model model){
        model.addAttribute("singlePost", postDao.getById(id));
        model.addAttribute("singleUser", postDao.getById(id).getUser());
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String returnUsersForm(Model model){
        model.addAttribute("users", userDao.findAll());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name="user") long id,
            @RequestParam(name="title") String title,
            @RequestParam(name="body") String body){
        try {
            Post newPost = new Post(userDao.getById(id),title, body);
            postDao.save(newPost);
            return "redirect:/posts";
        }catch(Exception e){
            throw new RuntimeException("Error adding new post to postDao");
        }
    }





}
