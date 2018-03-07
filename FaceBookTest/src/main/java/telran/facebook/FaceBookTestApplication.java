package telran.facebook;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
@SpringBootApplication
@CrossOrigin
public class FaceBookTestApplication extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(FaceBookTestApplication.class, args);
	}
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      http
	        .csrf().disable()
	        .antMatcher("/**")
	        .authorizeRequests()
	          .antMatchers("/", "/login**", "/webjars/**")
	          .permitAll()
	        .anyRequest()
	          .authenticated()
	        .and().logout().logoutSuccessUrl("/").permitAll();
	  }
	
	@GetMapping("/user")
	public String user(Principal user) {
		
		return "Hello " + user.getName();
	}
}
