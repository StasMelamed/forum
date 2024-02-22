package forum.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import forum.dao.ClientInterface;
import forum.dao.NewPostDto;
import forum.dao.NewPostDto;
import forum.dto.Comment;
import forum.dto.PeriodDto;
import forum.dto.PostDto;
import forum.dto.TagsDto;
import forum.dto.UpdateDto;
import forum.model.PostModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PersonController{
	
	@Autowired
	ClientInterface clientInterface;
	
	@PostMapping("/forum/post/{user}")	
	public PostDto addPost(@PathVariable("user") String user,@RequestBody NewPostDto newPostDto) {
		
		return clientInterface.addPost(user,newPostDto);
	}
	
	@GetMapping("/forum/post/{postId}")
	public PostDto findPostById(@PathVariable("postId") String postId) {
		
		return clientInterface.findPostById(postId);
		
	}
    
	@PutMapping("/forum/post/{postId}/like")
	public boolean addLike(@PathVariable("postId") String id) {
		
		return clientInterface.addLike(id);
	}

	@GetMapping("/forum/posts/author/{author}")
	public List<PostDto> findPostbyAuthor(@PathVariable("author") String author) {
		
		return clientInterface.findPostbyAuthor(author);
	}

	@PutMapping("/forum/post/{postId}/comment/{user}")
	public PostDto addComment(@PathVariable("postId") String postId,@PathVariable("user") String user,@RequestBody Comment comment) {
		
		return clientInterface.addComment(postId, user,comment);
	}

    @DeleteMapping("/forum/post/{id}")
	public PostDto deletePost(@PathVariable("id") String id) {
		
		return clientInterface.deletePost(id);
	}

	@PostMapping("/forum/posts/tags")
	public Iterable<PostDto> findPostByTags(@RequestBody List<String> tags) {
		
		return clientInterface.findPostByTags(tags);
	}

    @PostMapping("/forum/posts/period")
	public List<PostDto> findPostByPeriod(@RequestBody PeriodDto periodDto) {
		
		return clientInterface.findPostByPeriod(periodDto);
	}

    @PutMapping("/forum/post/{postId}")
	public PostDto updatePost(@PathVariable("postId") String id,@RequestBody UpdateDto updateDto) {
		
		return clientInterface.updatePost(id,updateDto);
	}
}
