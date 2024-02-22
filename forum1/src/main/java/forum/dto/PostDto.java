package forum.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	String id;
    String title;
    String content;
    String author;
    LocalDateTime dateCreated;
    ArrayList<String> tags;
    Integer likes;
    List<Comment> comments;

}
