package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String viewCreateForm () {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost () {
        return "create a new post";
    }
}
