package com.codeup.services;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2/8/17.
 */
@Service("postService")
public class PostService {
    public List<Post> showAllPosts () {
        return createListOfPosts();
    }

    public Post findPostByID (long id) {
        List<Post> posts = createListOfPosts();

        return posts.get((int)(id - 1));
    }

    private List<Post> createListOfPosts () {
        List<Post> posts = new ArrayList<>();

        for (long i = 0; i <= 10; i += 1) {
            Post post = new Post();
            post.setId(i + 1);
            post.setTitle("Title " + (i + 1));
            post.setBody("Body " + (i + 1));

            posts.add(post);
        }

        return posts;
    }
}
