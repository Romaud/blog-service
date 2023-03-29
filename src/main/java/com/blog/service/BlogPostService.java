package com.blog.service;

import com.blog.exception.ResourceNotFoundException;
import com.blog.model.BlogPost;
import com.blog.repository.BlogPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogPostService {
    private BlogPostRepository blogPostRepository;


    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost findById(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BlogPost", "id", id));
    }

    public BlogPost updateBlogPost(Long id, BlogPost blogPostDetails) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BlogPost", "id", id));

        blogPost.setTitle(blogPostDetails.getTitle());
        blogPost.setContent(blogPostDetails.getContent());

        return blogPostRepository.save(blogPost);
    }

    public BlogPost deleteById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BlogPost", "id", id));
        blogPostRepository.delete(blogPost);

        return blogPost;
    }
}
