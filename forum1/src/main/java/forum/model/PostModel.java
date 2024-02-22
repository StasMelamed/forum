package forum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import forum.dao.RepositoryInterface;
import forum.dto.Comment;
import forum.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
@Document(collection = "posts")
public class PostModel{

	String id;
	@Setter
    String title;
	@Setter
    String content;
	@Setter
    String author;
    LocalDateTime dateCreated;
    @Setter
    List<String> tags = new ArrayList<>();
    @Setter
    Integer likes;
    
    List<Comment> comments = new ArrayList<>();
    
	public PostModel(String author) {
		
		this.author = author;
		this.dateCreated = LocalDateTime.now();

		
		
	}
    
    
    
    

}
