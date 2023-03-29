package com.blog.dto;

import com.blog.model.BlogPost;
import com.blog.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogPostDto {
    private Long id;
    private String title;
    private String content;
    private User author;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public BlogPostDto(BlogPost blogPost) {
        this.id = blogPost.getId();
        this.title = blogPost.getTitle();
        this.content = blogPost.getContent();
        this.author = blogPost.getAuthor();
        this.createdDate = blogPost.getCreatedDate();
        this.updatedDate = blogPost.getUpdatedDate();
    }
}
