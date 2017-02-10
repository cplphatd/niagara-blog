package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by David on 2/7/17.
 */
@Controller
public class PostsController {

    @Autowired
    private Posts postsDao;

    @GetMapping("/posts")
    public String getPosts (Model model) {

        model.addAttribute("posts", postsDao.findAll());

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost (@PathVariable long id, Model model) {

        Post post = postsDao.findOne(id);

        model.addAttribute("post", post);

        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm (Model model) {

        model.addAttribute("post", new Post());

        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost (@ModelAttribute Post post) {

        postsDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm (@PathVariable long id, Model model) {

        Post post = postsDao.findOne(id);

        model.addAttribute(post);

        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost (@ModelAttribute Post post) {

        postsDao.save(post);

        return "redirect:/posts/{id}";
    }
 }
