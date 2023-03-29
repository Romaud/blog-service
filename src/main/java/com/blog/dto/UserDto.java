package com.blog.dto;

import com.blog.model.BlogPost;
import com.blog.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<BlogPost> posts;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.posts = user.getPosts();
    }
}
