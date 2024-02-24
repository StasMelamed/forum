package forum.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import forum.dao.ClientInterface;
import forum.dao.NewPostDto;
import forum.dao.RepositoryInterface;
import forum.dto.Comment;
import forum.dto.ExceptionsDto;
import forum.dto.PeriodDto;
import forum.dto.PostDto;
import forum.dto.TagsDto;
import forum.dto.UpdateDto;
import forum.model.PostModel;

@Component
public class ForumImpl implements ClientInterface {
	
	@Autowired
	RepositoryInterface repositoryInterface;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public PostDto addPost(String user,NewPostDto newPostDto) {
		
		PostModel  postModel= new PostModel(user);
		
		postModel.setTitle(newPostDto.getTitle());
		postModel.setContent(newPostDto.getContent());
		List<String> tagsList = newPostDto.getTags();
		postModel.setTags(tagsList);
					
		repositoryInterface.save(postModel);
		
		return modelMapper.map(postModel,PostDto.class) ;
	}

	@Override
	public PostDto findPostById(String id) {
		
		PostModel postModel = repositoryInterface.findById(id).orElseThrow(ExceptionsDto::new);
		
		return modelMapper.map(postModel, PostDto.class);
	}

	@Override
	public boolean addLike(String id) {
		
		PostModel postModel = repositoryInterface.findById(id).orElseThrow(ExceptionsDto::new);
		
		if(postModel.getLikes()!=null) {
		postModel.setLikes(postModel.getLikes()+1);
		}
		else postModel.setLikes(1);
		
	    repositoryInterface.save(postModel);
		return true;
		 
	}

	@Override
	public List<PostDto> findPostbyAuthor(String author) {
		
		Collection<PostModel> postModel = repositoryInterface.findByAuthorIgnoreCase(author);
		
		List<PostDto> result = new ArrayList<PostDto>();
		
		for (PostModel model:postModel) {
			result.add(modelMapper.map(model, PostDto.class));	
			}
		
		return result;
	}

	@Override
	public PostDto addComment(String id, String user,Comment comment) {
		
		PostModel postModel = repositoryInterface.findById(id).orElseThrow(ExceptionsDto::new);
	
		comment.setUser(user);
		postModel.getComments().add(comment);
	
		repositoryInterface.save(postModel);
		
		return modelMapper.map(postModel, PostDto.class);
	}

	@Override
	public PostDto deletePost(String id) {
		
		PostModel postModel = repositoryInterface.findById(id).orElseThrow(ExceptionsDto::new);
		
		repositoryInterface.delete(postModel);
		
		return modelMapper.map(postModel, PostDto.class);
	}

	@Override
	public List<PostDto> findPostByTags(List<String> tags) {
		
		
		
 Collection<PostModel> postModels = repositoryInterface.findByTagsContaining(tags).orElseThrow(ExceptionsDto::new);
		

	//List<PostDto> postDtos = new ArrayList<>();
	
//	for(PostModel postModel:postModels) {
//		
//	PostDto postDto= modelMapper.map(postModel, PostDto.class);
//	
//	postDtos.add(postDto);
//	}
		
		return postModels.stream().map(t->modelMapper.map(t, PostDto.class)).toList();
	}

	@Override
	public List<PostDto> findPostByPeriod(PeriodDto periodDto) {
		

		LocalDate dateOne= periodDto.getDateFrom();
		LocalDate dateTwo= periodDto.getDateTo();

	List<PostModel>	postModels= repositoryInterface.findByDateCreatedBetween(dateOne,dateTwo);

	
	return postModels.stream().map(t->modelMapper.map(t, PostDto.class)).toList();
	}

	@Override
	public PostDto updatePost(String id,UpdateDto updateDto) {
		
		PostModel postModel = repositoryInterface.findById(id).orElseThrow(ExceptionsDto::new);
		
		postModel.setTitle(updateDto.getTitle());
		postModel.setTags(updateDto.getTags());
		postModel.setContent(updateDto.getContent());
		
		repositoryInterface.save(postModel);
		
		return modelMapper.map(postModel, PostDto.class);
	}

}
