package com.ejazz.post_service.service;

import com.ejazz.post_service.dto.PostDTO;
import com.ejazz.post_service.entity.Post;
import com.ejazz.post_service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PostDTO createPost(PostDTO postDTO) {
        Post post = toEntity(postDTO);
        Post saved = postRepository.save(post);
        return toDTO(saved);
    }

    private PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }

    private Post toEntity(PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return post;
    }
}
