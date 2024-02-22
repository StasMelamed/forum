package forum.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;

import forum.dto.Comment;
import forum.dto.PeriodDto;
import forum.dto.PostDto;
import forum.dto.TagsDto;
import forum.dto.UpdateDto;
import forum.model.PostModel;

public interface ClientInterface {
	
	PostDto addPost(String user,NewPostDto newPostDto);
	
	PostDto findPostById(String id);
	
	boolean addLike(String id);
	
	List<PostDto> findPostbyAuthor(String author);
	
	PostDto addComment(String id,String user,Comment comment);
	
	PostDto deletePost(String id);
	
	Iterable<PostDto> findPostByTags(List<String> tags);
	
	List<PostDto> findPostByPeriod(PeriodDto periodDto);
	
	PostDto updatePost(String id,UpdateDto updateDto);
	

}
