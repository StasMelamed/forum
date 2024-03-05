package java51.configuration;

import org.springframework.aot.nativex.NativeConfigurationWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import lombok.RequiredArgsConstructor;
import java51.accounting.model.Role;
import java51.security.filter.CustomWebSecurity;

@Configuration
@RequiredArgsConstructor
public class HttpConfig {

	final CustomWebSecurity customSecurity;

	@Bean
	public SecurityFilterChain web(HttpSecurity http) throws Exception {
	
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		
		//включить sessions
		
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
		
		//включить sessions
		
		http.authorizeHttpRequests(authorize -> authorize
				
				
				
				
				
				
				
				.requestMatchers("/account/register","/forum/posts/**")
				.permitAll()
				.requestMatchers("/account/user/{user}/role/{role}")
				.hasRole(Role.ADMIN.name())
				.requestMatchers(HttpMethod.PUT, "/account/user/{user}")
				.access(new WebExpressionAuthorizationManager("#user==authentication.name"))
				.requestMatchers(HttpMethod.DELETE, "/account/user/{user}")
				.access(new WebExpressionAuthorizationManager("#user==authentication.name or hasRole('ADMIN')"))
				.requestMatchers(HttpMethod.POST, "/forum/post/{user}")
				.access(new WebExpressionAuthorizationManager("#user==authentication.name"))
				.requestMatchers(HttpMethod.PUT, "/forum/post/{id}/comment/{user}")
				.access(new WebExpressionAuthorizationManager("#user==authentication.name"))
				.requestMatchers(HttpMethod.PUT, "/forum/post/{postId}")
				//.access(new WebExpressionAuthorizationManager("@customSecurity.checkPostAuthor(#postId,authentication.name)"))
				.access((authentication, context) ->
				new AuthorizationDecision(customSecurity.checkPostAuthor(context.getVariables().get("postId"), authentication.get().getName())))
				
				.requestMatchers(HttpMethod.DELETE, "/account/user/{user}")
				.access((authentication,context)->
				new AuthorizationDecision(customSecurity.checkPostAuthor(context.getVariables().get("user"),authentication.get().getName())
						||context.getRequest().isUserInRole(Role.ADMIN.name())))
				
				
//				.requestMatchers("/account/register", "/forum/posts/**")
//					.permitAll()ws
//				.requestMatchers("/account/user/{login}/role/{role}")
//					.hasRole(Role.ADMIN.name())
//				.requestMatchers(HttpMethod.PUT, "/account/user/{login}")
//					.access(new WebExpressionAuthorizationManager("#login == authentication.name"))
//				.requestMatchers(HttpMethod.DELETE, "/account/user/{login}")
//					.access(new WebExpressionAuthorizationManager("#login == authentication.name or hasRole('ADMINISTRATOR')"))
//				.requestMatchers(HttpMethod.POST, "/forum/post/{author}")
//					.access(new WebExpressionAuthorizationManager("#author == authentication.name"))
//				.requestMatchers(HttpMethod.PUT, "/forum/post/{id}/comment/{author}")
//					.access(new WebExpressionAuthorizationManager("#author == authentication.name"))
//				.requestMatchers(HttpMethod.PUT, "/forum/post/{id}")
////					.access(new WebExpressionAuthorizationManager("@customSecurity.checkPostAuthor(#id, authentication.name)"))
//					.access((authentication, context) ->
//					new AuthorizationDecision(webSecurity.checkPostAuthor(context.getVariables().get("id"), authentication.get().getName())))
//				.requestMatchers(HttpMethod.DELETE, "/forum/post/{id}")
//					.access((authentication, context) -> {						
//						boolean checkAuthor = webSecurity.checkPostAuthor(context.getVariables().get("id"), authentication.get().getName()) ;
////						boolean checkModerator = authentication.get().getAuthorities().containsAll(AuthorityUtils.createAuthorityList("ROLE_" + Role.MODERATOR.name()));
//		e			boolean checkModerator = context.getRequest().isUserInRole(Role.MODERATOR.name());
//						return new AuthorizationDecision(checkAuthor || checkModerator); 
//					})			
				
				
				
				.anyRequest()
					.authenticated()
		);
		return http.build();
	}
}