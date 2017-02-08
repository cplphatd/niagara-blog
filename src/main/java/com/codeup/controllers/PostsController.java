package com.codeup.controllers;

import com.codeup.models.Post;
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

    @GetMapping("/posts")
    public String getPosts (Model model) {
        List<Post> posts = new ArrayList<>();

        Post postOne = new Post();
        postOne.setTitle("Test 1");
        postOne.setBody("Test body 1");

        posts.add(postOne);

        Post postTwo = new Post();
        postTwo.setTitle("Test 2");
        postTwo.setBody("Test body 2");

        posts.add(postTwo);

        model.addAttribute("posts", posts);

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost (@PathVariable long id, Model model) {
        Post post = new Post();
        post.setTitle("Test");
        post.setBody("Test body.");
        post.setId(id);

        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        model.addAttribute("id", post.getId());

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
