package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2/7/17.
 */
@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public String getPosts (Model model) {

        List<Post> posts = postService.showAllPosts();

        model.addAttribute("posts", posts);

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost (@PathVariable long id, Model model) {

        Post post = postService.findPostByID(id);

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

        postService.savePost(post);

        return "/posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm (@PathVariable long id, Model model) {

        Post post = postService.findPostByID(id);

        model.addAttribute(post);

        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost (@PathVariable long id, @ModelAttribute Post post) {
        return null;
    }
 }
