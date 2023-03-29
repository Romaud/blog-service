package com.blog.controller;

import com.blog.model.BlogPost;
import com.blog.model.User;
import com.blog.service.BlogPostService;
import com.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class BlogPostController {
    private BlogPostService blogPostService;
    private UserService userService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.findAll();
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost, @RequestParam Long authorId) {
        User user = userService.findById(authorId);
        blogPost.setAuthor(user);
        return ResponseEntity.ok(blogPostService.save(blogPost));
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id,
                                                   @RequestBody BlogPost blogPostDetails) {
        return ResponseEntity.ok(blogPostService.updateBlogPost(id, blogPostDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BlogPost> deleteBlogPost(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.deleteById(id);
        return ResponseEntity.ok(blogPost);
    }
}
