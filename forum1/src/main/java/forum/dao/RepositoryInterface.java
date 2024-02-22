package forum.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import forum.dto.PostDto;
import forum.dto.TagsDto;
import forum.model.PostModel;

public interface RepositoryInterface extends CrudRepository<PostModel, String>{

Collection<PostModel> findByAuthor(String author);

Optional<Collection<PostModel>> findByTagsContaining(List<String> tags);

List<PostModel> findByDateCreatedBetween(LocalDate dateOne, LocalDate dateTwo);

Collection<PostModel> findByAuthorIgnoreCase(String author);

	
}
