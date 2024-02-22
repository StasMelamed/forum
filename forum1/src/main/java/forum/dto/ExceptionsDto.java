package forum.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionsDto extends RuntimeException{

	private static final long serialVersionUID = -8476991511082916964L;
	
	

}
