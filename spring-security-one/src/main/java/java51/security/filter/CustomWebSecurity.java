package java51.security.filter;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java51.post.dao.PostRepository;
import java51.post.model.Post;

@Service("customSecurity")
@RequiredArgsConstructor
public class CustomWebSecurity {
	final PostRepository postRepository;

	public boolean checkPostAuthor(String postId, String userName) {
		Post post = postRepository.findById(postId).orElse(null);
		return post != null && userName.equals(post.getAuthor());
	}
}