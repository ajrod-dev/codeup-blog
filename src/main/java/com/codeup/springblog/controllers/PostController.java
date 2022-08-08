package com.codeup.springblog.controllers;
import com.codeup.springblog.models.EmailService;
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

    private EmailService service;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService service){
        this.postDao = postDao;
        this.userDao = userDao;
        this.service = service;
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
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute("post") Post post){
        try {
            post.setUser(userDao.getById(1L));
            postDao.save(post);
            service.prepareAndSend(userDao.getById(1L),
                    "New Post Alert",
                    "A new Post was createed by " + userDao.getById(1L).getUsername());
            return "redirect:/posts";
        }catch(Exception e){
            throw new RuntimeException("Error adding new post to postDao");
        }
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model model){
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("post", postDao.getById(id));
        return "posts/create";
    }
//
//    @PostMapping("/posts/{id}/edit")
//    public String editPost(@ModelAttribute Post post){
//        try {
//            postDao.save(post);
//            return "redirect:/posts";
//        }catch(Exception e){
//            throw new RuntimeException("Error adding new post to postDao");
//        }
//    }





}
