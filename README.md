🛡️ Spring Security

Spring Security is a powerful and customizable authentication and access-control framework for securing Spring-based web and REST applications.

🔐 Core Concepts

Authentication
Verifies who is accessing the application (e.g., login with username/password).

Authorization
Verifies what the authenticated user is allowed to access (e.g., roles, permissions).

⚙️ Default Behavior

When you add the Spring Security dependency to your Spring Boot application, it:

Automatically applies HTTP Basic Authentication

Generates a default username: user

Displays a random password in the console at startup


👤 Default Credentials
  Key	                Value
Username	            user
Password	        See console (Startup Logs)

🔗 Accessing a Secured API
1. Via Browser (e.g., Chrome)
You'll see a default Spring Security login page.

Enter the default or configured credentials.

2. Via Postman
Go to the Authorization tab

Choose type: Basic Auth

Enter your username and password

🔐 Or manually add to headers:

Authorization: Basic Base64Encode(username:password)

3. Programmatically (via RestTemplate or WebClient)
   
You must add authentication headers while sending the request.

Example using RestTemplate:
RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("user", "password"); // Replace with your values
HttpEntity<String> entity = new HttpEntity<>(headers);

ResponseEntity<String> response = restTemplate.exchange(
    "http://localhost:8080/secured-endpoint",
    HttpMethod.GET,
    entity,
    String.class
);
System.out.println(response.getBody());

🔧 Overriding Default Credentials

Set custom username and password in application.properties:

spring.security.user.name=admin
spring.security.user.password=admin123

🔐 Custom Security Configuration

Create a SecurityFilterChain bean to override default behavior:
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic()
            .and()
            .csrf().disable(); // Disable for REST APIs

        return http.build();
    }
}
✅ Summary

🔒 Spring Security protects both Web & REST APIs.

🧰 Adding the dependency auto-enables basic security.

🛠 You can customize access rules using SecurityFilterChain.

🔗 APIs can be accessed using browser, Postman, or programmatically via RestTemplate or WebClient.

