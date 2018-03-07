package telran.facebook;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class FaceBookTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaceBookTestApplication.class, args);
	}
	
	@GetMapping("/")
	public String home(Principal user) {
		
		return "Hello " + user.getName();
	}
}
