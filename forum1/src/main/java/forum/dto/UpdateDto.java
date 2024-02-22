package forum.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class UpdateDto {

	String title;
    List<String> tags;
    String content;
	
}
