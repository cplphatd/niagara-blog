package com.codeup.services;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2/8/17.
 */
@Service("postService")
public class PostService {
    List<Post> posts = new ArrayList<>();

    public PostService () {
        this.posts = createListOfPosts();
    }

    public List<Post> showAllPosts () {
        return posts;
    }

    public Post findPostByID (long id) {
        posts = createListOfPosts();

        return posts.get((int)(id - 1));
    }

    public void savePost (@ModelAttribute Post post) {
        posts = createListOfPosts();

        posts.add(post);
        long id = (long) (posts.indexOf(post) + 1);
        posts.remove(post);

        post.setId(id);

        posts.add(post);
    }

    private List<Post> createListOfPosts () {

        for (long i = 0; i < 10; i += 1) {
            Post post = new Post();
            post.setId(i + 1);
            post.setTitle("Title " + (i + 1));
            post.setBody("Body " + (i + 1));

            posts.add(post);
        }

        return posts;
    }
}
