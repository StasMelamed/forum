package forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	   @Setter
       String user;
	   @Setter
       String message;
       LocalDateTime dateCreated=LocalDateTime.now();
       @Setter
       Integer likes;
       
       

}
